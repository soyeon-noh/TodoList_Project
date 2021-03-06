package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoListVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;


@WebServlet("/UD/*")
public class TodoListController extends HttpServlet{

	protected TodoService tdService;
	
	public TodoListController() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		if(subPath.equals("/delete")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			tdService.delete(td_seq);
			resp.sendRedirect("/todo");
			
		} else if(subPath.equals("/update")) {
			// TODO update 실행하기 전 화면 보여주기
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			
			TodoListVO tdVO = tdService.findById(td_seq);
			
			// SimpleDateFormat : 날짜 및 시간을 형식화하고 구문 분석하는 메소드 제공
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			
			// 현재시간을 저장
			Date date = new Date(System.currentTimeMillis());
			
			// 현재 시간을 변환해 VO에 넣어준다
			tdVO.setTd_date(sd.format(date));
			tdVO.setTd_time(st.format(date));
			
			req.setAttribute("TD", tdVO);
			
			RequestController.reqController(req, resp, "update");
			
		} else if(subPath.equals("/select")) {
			String td_date = req.getParameter("td_date");
			
			
				List<TodoListVO> tdList = tdService.findByDate(td_date);
				req.setAttribute("TDLIST", tdList);	
				RequestController.reqController(req, resp, "home");
			
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO insert()
		
		// 한글 인코딩 세팅
		req.setCharacterEncoding("UTF-8");

		// subPath 가져오기
		String subPath = req.getPathInfo();
		
		
		if(subPath.equals("/update")) {
			
			// 사용자가 화면에 입력한 값 가져오기
			String td_date = req.getParameter("td_date");
			String td_time = req.getParameter("td_time");
			String td_todo = req.getParameter("td_todo");
			String td_place = req.getParameter("td_place");
	
			TodoListVO tdVO = new TodoListVO();
			tdVO.setTd_date(td_date);
			tdVO.setTd_time(td_time);
			tdVO.setTd_todo(td_todo);
			tdVO.setTd_place(td_place);
		
			// seq
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			
			tdVO.setTd_seq(td_seq);
			
			// 시퀀스까지 적어넣고 update
			tdService.update(tdVO);
			
			// 그리고 주소 이동
			resp.sendRedirect("/todo");
			
			
		} 
		
		
	}
	
	
}
