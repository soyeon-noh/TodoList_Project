package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoListVO {

	private Long td_seq;	//BIGINT
    private String td_date;	//VARCHAR(20)
    private String td_time;	//VARCHAR(20)
	private String td_todo;	//VARCHAR(200)
    private String td_place;	//VARCHAR(125)
}
