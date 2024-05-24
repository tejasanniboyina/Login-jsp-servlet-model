package com.teja.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teja.login.model.LoginFormModel;

public class LoginDao {

	public boolean verifyLogin(LoginFormModel loginModel) throws ClassNotFoundException {
		boolean status = false;
		String url = "jdbc:mysql://localhost:3306/employees";
		String uname = "root";
		String pword = "";
		String fetchQuery = "SELECT * FROM login where username=? and password=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection(url, uname, pword);
				PreparedStatement prepareStatement = connection.prepareStatement(fetchQuery)){
			prepareStatement.setString(1, loginModel.getUsername());
			prepareStatement.setString(2, loginModel.getPassword());
			
			ResultSet rs= prepareStatement.executeQuery();
			status = rs.next();
			
		}
		catch(SQLException e) {
			
		}
		return status;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
