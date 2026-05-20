package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitConnection {

public static Connection createConnection(){
	Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localHost:3306/jdbc_product","root","Yash@2311");
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
