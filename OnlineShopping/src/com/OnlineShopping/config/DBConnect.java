package com.OnlineShopping.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnect {
	public static Connection getConnect() {
		Connection con=null;
		try {
	        //For H2-Database
		//Class.forName("org.h2.Driver");
		//con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/shopping-site","sa","sa");
			
			//For MySQLServer 5.0
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vijay","root","root");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
