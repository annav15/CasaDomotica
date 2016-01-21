package com.unisannio.casadomotica.java;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
 
public class DataBase {
 
  public DataBase(String user, String password) throws SQLException {
 
	System.out.println("MySQL JDBC Test di connessione");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Manca il JDBC Driver");
		e.printStackTrace();
		return;
	}
 
	System.out.println("MySQL JDBC Driver [ok]");
	Connection connection = null;
 
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arduino1","michele","");
	
		
	} catch (SQLException e) {
		System.out.println("Connessione fallita!");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("Connessione [ok]");
	} else {
		System.out.println("Connessione fallita!");
	}
  
  
  
  
	
	
	
	stmt =  (Statement) connection.createStatement();
	
	
	
	  
  
}


 public Statement getStatement() {
	 return stmt;
 }

 public ResultSet getResultSet() {
	 return rs;
 }
 

 private Statement stmt;
 private ResultSet rs;
 
}