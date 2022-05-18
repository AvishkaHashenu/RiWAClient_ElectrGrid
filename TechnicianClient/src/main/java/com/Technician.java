package com;

import java.sql.*;

public class Technician {

	public Connection connect(){
        //database connection details
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/";
        String dbName = "electrogrid";
        String dbUsername = "root";
        String dbPassword = "root";
        
        Connection conn = null;
        
        try {
        	//connecting the database
        	Class.forName(dbDriver);
        	conn = DriverManager.getConnection(dbURL+dbName, dbUsername, dbPassword);
        	
        	//if successfully connected this will be printed in the terminal
        	System.out.print("Database connected successfully");
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return conn;
    }

    
    public String readTechnicians()
    {
    	String output = "";
    	try
    	{
    		Connection con = connect();
    		if (con == null)
    		{
    			return "Error while connecting to the database for reading.";
    		}
    		// Prepare the html table to be displayed
    		output = "<table border='1'><tr><th>Technician ID</th> <th>Technician Name</th><th>Technician Address</th>" 
    		+ "<th>Technician Email</th> <th>Technician Phone</th> <th>Type</th> <th>ContractTech_Salary</th><th>HourlyTech_HourlyWages</th><th>Update</th><th>Remove</th></tr>";
    
    		String query = "select * from power_technician";
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(query);
    		// iterate through the rows in the result set
    		while (rs.next())
    		{
    			String TechnicianID = Integer.toString(rs.getInt("TechnicianID"));
				String TechnicianName = rs.getString("TechnicianName");
				String TechnicianAddress = rs.getString("TechnicianAddress");
				String TechnicianEmail = rs.getString("TechnicianEmail");
				String TechnicianPhone = rs.getString("TechnicianPhone");
				String Type = rs.getString("Type");
				String ContractTech_Salary = Double.toString(rs.getDouble("ContractTech_Salary"));
				String HourlyTech_HourlyWages = Double.toString(rs.getDouble("HourlyTech_HourlyWages"));
    			// Add into the html table
    			output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + TechnicianID
    					+ "'>" + "</td></tr>";
    			output += "<tr><td>" + TechnicianID + "</td>";
				output += "<td>" + TechnicianName + "</td>";
				output += "<td>" + TechnicianAddress + "</td>";
				output += "<td>" + TechnicianEmail + "</td>";
				output += "<td>" + TechnicianPhone + "</td>";
				output += "<td>" + Type + "</td>";
				output += "<td>" + ContractTech_Salary + "</td>";
				output += "<td>" + HourlyTech_HourlyWages + "</td>";
    
    			// buttons
    			output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-itemid='"+ TechnicianID + "'>" + "</td>"
    					+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"+ TechnicianID + "'>" + "</td></tr>";
    		}
    		con.close();
    		// Complete the html table
    		output += "</table>";
    }
    catch (Exception e)
    {
    	output = "Error while reading the technicians.";
    	System.err.println(e.getMessage());
    }
    	return output;
    }
    
    
  //method to insert data
    public String insertTechnician(String TechnicianName, String TechnicianAddress, String TechnicianEmail, String TechnicianPhone, String Type, String ContractTech_Salary, String HourlyTech_HourlyWages)
    {
    	String output = "";
    	try
    	{
    		Connection con = connect();
    		if (con == null)
    		{
    			return "Error while connecting to the database for inserting.";
    		}
    		// create a prepared statement
    		String query = " insert into power_technician(`TechnicianID`,`TechnicianName`,`TechnicianAddress`,`TechnicianEmail`,`TechnicianPhone`,`Type`,`ContractTech_Salary`,`HourlyTech_HourlyWages`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
    		// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, TechnicianName);
			preparedStmt.setString(3, TechnicianAddress);
			preparedStmt.setString(4, TechnicianEmail);
			preparedStmt.setInt(5, Integer.parseInt(TechnicianPhone));
			preparedStmt.setString(6, Type);
			preparedStmt.setDouble(7, Double.parseDouble(ContractTech_Salary));
			preparedStmt.setDouble(8, Double.parseDouble(HourlyTech_HourlyWages));
    		// execute the statement
    		preparedStmt.execute();
    		con.close();
    		String newTechnicians = readTechnicians();
    		output = "{\"status\":\"success\", \"data\": \"" + newTechnicians + "\"}";
    	}
    	catch (Exception e)
    	{
    		output = "{\"status\":\"error\", \"data\":\"Error while inserting the technician.\"}";
    		System.err.println(e.getMessage());
    	}
    	return output;
    }
    
    
    public String deleteTechnician(String TechnicianID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for deleting."; 
	 } 
	 // create a prepared statement
	 String query = "delete from power_technician where TechnicianID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(TechnicianID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 String newTechnicians = readTechnicians(); 
	 output = "{\"status\":\"success\", \"data\": \"" + newTechnicians + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
    
    
    
    public String updateTechnician(String TechnicianID, String TechnicianName, String TechnicianAddress, String TechnicianEmail, String TechnicianPhone, String Type, String ContractTech_Salary, String HourlyTech_HourlyWages)
    {
		String output = "";
		String decodename = java.net.URLDecoder.decode(TechnicianName);
		String decodeaddress = java.net.URLDecoder.decode(TechnicianAddress);
		String decodeemail = java.net.URLDecoder.decode(TechnicianEmail);
		
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE power_technician SET TechnicianName=?,TechnicianAddress=?,TechnicianEmail=?,TechnicianPhone=?,Type=?,ContractTech_Salary=?,HourlyTech_HourlyWages=? WHERE TechnicianID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, decodename);
			preparedStmt.setString(2, decodeaddress);
			preparedStmt.setString(3, decodeemail);
			preparedStmt.setString(4, TechnicianPhone);
			preparedStmt.setString(5, Type);
			preparedStmt.setDouble(6, Double.parseDouble(ContractTech_Salary));
			preparedStmt.setDouble(7, Double.parseDouble(HourlyTech_HourlyWages));
			preparedStmt.setInt(8, Integer.parseInt(TechnicianID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUsers =  readTechnicians(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newUsers + "\"}"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the Technician.\"}"; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
    
    

}
