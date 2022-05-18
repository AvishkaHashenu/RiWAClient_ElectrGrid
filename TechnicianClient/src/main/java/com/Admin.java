package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String login(String username, String password) 
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for login"; 
			}

			String query = "select username, password, userRole from user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				String userName = rs.getString("username");
				String pass = rs.getString("password");
				String userRole = rs.getString("userRole");

				if(username.equals(userName) && password.equals(pass) && userRole.equals("Admin"))
				{

					output = "success";
					return output;

				}		
			}
		}
		catch (Exception e)
		{

			System.err.println(e.getMessage());
		}
		output = "Incorrect Username or Password";
		return output;

	}

//	public String login(String un, String pw) 
//	{ 
//	 String output = ""; 
//	if (!un.equals("asd"))//Hard coded test value 
//	 { 
//	 output = "Invalid username"; 
//	 } 
//	else if (un.equals("asd"))//Hard coded test value 
//	 { 
//	 if (!pw.equals("asd"))//Hard coded test value 
//	 { 
//	 output = "Invalid password"; 
//	 } 
//	 else if (pw.equals("asd"))//Hard coded test value 
//	 { 
//	 output = "success"; 
//	 } 
//	 } 
//	return output; 
//	}
}
