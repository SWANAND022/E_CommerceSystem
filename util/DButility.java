package com.db.util;
import java.sql.*;

public class DButility {

	public static Connection makeConnection() throws SQLException {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip_6201?user=root&password=swanand@321");
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
