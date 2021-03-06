package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.TodoListVO;

public interface TodoService {
	
	public List<TodoListVO> selectAll();
	public TodoListVO findById(Long seq);
	
	public List<TodoListVO> findByDate(String td_date);
	
	public Integer insert(TodoListVO tdVO);
	public Integer update(TodoListVO tdVO);
	public Integer delete(Long seq);

}
