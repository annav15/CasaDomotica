package com.unisannio.casadomotica.model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Statement;

public class ascoltoDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat(); // creo l'oggetto
	    String dataStr = sdf.format(new Timestamp(0));
		DataBase db=new DataBase("michele","");
		Statement stmt = db.getStatement();
		Preleva preleva=new Preleva();
	
		int i=1;
		while (true){
		
						
		  
			//Aggiungo accout al database
			String insert = "INSERT INTO temperature (id,tempINT,tempEST) VALUES ("+i+++",'"+preleva.getTempInterna()+"','"+preleva.getTempEsterna()+"')"; 
			stmt.executeUpdate(insert);


		
		
		}
		
	}

}
