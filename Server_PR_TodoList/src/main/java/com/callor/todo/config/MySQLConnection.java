package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/todolist";
		String username = "tdUser";
		String password = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("MySQL 접속 성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL Driver 를 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("MySQL DBMS 연결 실패");
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
	
}
