package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoListVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/todo/*")
public class TodoListController extends HttpServlet{

	protected TodoService tdService;
	
	public TodoListController() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
