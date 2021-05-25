package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DbInfo;
import com.callor.todo.config.MySQLConnection;
import com.callor.todo.model.TodoListVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService{

	// 먼저 db와 연결
	protected Connection dbConn;
	
	public TodoServiceImplV1() {
		dbConn = MySQLConnection.getDBConnection();
	}
	
	
	protected List<TodoListVO> select(PreparedStatement pStr) throws SQLException{
		// TODO DB로부터 데이터를 받아와 List에 저장
		List<TodoListVO> tdList = new ArrayList<TodoListVO>();
		
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			TodoListVO tdVO = new TodoListVO();
			tdVO.setTd_seq(rSet.getLong(DbInfo.td_seq));
			tdVO.setTd_date(rSet.getString(DbInfo.td_date));
			tdVO.setTd_time(rSet.getString(DbInfo.td_time));
			tdVO.setTd_todo(rSet.getString(DbInfo.td_todo));
			tdVO.setTd_place(rSet.getString(DbInfo.td_place));
			tdList.add(tdVO);
		}
		
		// 데이터 확인
		System.out.println("select : " + tdList.toString());
		return tdList;
	}
	
	@Override
	public List<TodoListVO> selectAll() {
		// TODO List 전체 데이터 조회
		
		String sql = " SELECT * FROM tbl_todo_list ";
		sql += " ORDER BY td_date DESC, td_time DESC ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoListVO> tdList = this.select(pStr);
			pStr.close();
			
			System.out.println("selectAll : " + tdList.toString());
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TodoListVO findById(Long seq) {
		// TODO 일련번호로 조회
		String sql = " SELECT * FROM tbl_todo_list ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			
			List<TodoListVO> tdList = this.select(pStr);
			
			pStr.close();
			
			if(tdList != null && tdList.size() > 0) {
				return tdList.get(0);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TodoListVO> findByDate(String td_date) {
		// TODO 날짜로 조회
		String sql = " SELECT * FROM tbl_todo_list ";
		sql += " WHERE td_date = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, td_date);
			
			List<TodoListVO> tdList = this.select(pStr);
			
			pStr.close();
			return tdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Integer insert(TodoListVO tdVO) {
		// TODO 데이터 추가
		
		String sql = " INSERT INTO tbl_todo_list ";
		sql += " ( ";
		sql += " td_date, ";
		sql += " td_time, ";
		sql += " td_todo, ";
		sql += " td_place) ";
		sql += " VALUES( ?,?,?,? ) ";
		
		
		// SQL 구문을 실행시키는 객체
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_todo());
			pStr.setString(4, tdVO.getTd_place());
			
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Integer update(TodoListVO tdVO) {
		// TODO 데이터 업데이트
		String sql = " UPDATE tbl_todo_list SET ";
		sql += " td_date = ?, ";
		sql += " td_time = ?, ";
		sql += " td_todo = ?, ";
		sql += " td_place = ? ";
		
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_todo());
			pStr.setString(4, tdVO.getTd_place());
			
			pStr.setLong(5, tdVO.getTd_seq());
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO 데이터 삭제
		
		String sql = " DELETE FROM tbl_todo_list ";
		sql += "WHERE td_seq = ?";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
