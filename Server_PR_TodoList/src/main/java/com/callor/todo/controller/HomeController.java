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

@WebServlet("/")
public class HomeController extends HttpServlet{

	protected TodoService tdService;
	public HomeController() {
		tdService = new TodoServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO selectAll()
		List<TodoListVO> tdList = tdService.selectAll();
		req.setAttribute("TDLIST", tdList);
		
		// TODO insert()
		TodoListVO tdVO = new TodoListVO();
		
		// SimpleDateFormat : 날짜 및 시간을 형식화하고 구문 분석하는 메소드 제공
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
		
		// 현재시간을 저장
		Date date = new Date(System.currentTimeMillis());
		
		// 현재 시간을 변환해 VO에 넣어준다
		tdVO.setTd_seq(0L);
		tdVO.setTd_date(sd.format(date));
		tdVO.setTd_time(st.format(date));
		
		req.setAttribute("TD", tdVO);
		
		// home.jsp 화면을 보여줘라
		RequestController.reqController(req, resp, "home");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO insert()
		
		// 한글 인코딩 세팅
		req.setCharacterEncoding("UTF-8");
		
		// user가 입력한 data 확인
		String td_date = req.getParameter("td_date");
		String td_time = req.getParameter("td_time");
		String td_todo = req.getParameter("td_todo");
		String td_place = req.getParameter("td_place");
		
		TodoListVO tdVO = new TodoListVO();
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_todo(td_todo);
		tdVO.setTd_place(td_place);
		
		tdService.insert(tdVO);
		
		System.out.println("insert : " + tdVO);
		
		resp.sendRedirect("/todo");
	}

}
