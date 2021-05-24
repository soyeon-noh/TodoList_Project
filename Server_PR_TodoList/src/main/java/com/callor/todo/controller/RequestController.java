package com.callor.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestController extends HttpServlet{
	
	public static void reqController (HttpServletRequest req, 
			HttpServletResponse resp, String file) throws ServletException, IOException {
		
		String root = "/WEB-INF/views/" + file + ".jsp";
		
		req.getRequestDispatcher(root)
		.forward(req, resp);
		
		
	}

}
