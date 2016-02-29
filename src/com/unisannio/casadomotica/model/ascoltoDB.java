package com.unisannio.casadomotica.model;

import java.sql.SQLException;


import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
public class ascoltoDB {
	
   static Preleva preleva=new Preleva();
	static Statement stmt ;
	static ResultSet rs;
	
	
	
	public static String getOraAttuale()
	{
	java.util.TimeZone t=java.util.TimeZone.getTimeZone("ECT");
	java.util.Calendar oggi = java.util.Calendar.getInstance(t);

	String s = "";
	String millisecondi = "" + oggi.get(oggi.MILLISECOND);
	String secondi = "" + oggi.get(oggi.SECOND);
	String minuti = "" + oggi.get(oggi.MINUTE);
	String ora = "" +oggi.get(oggi.HOUR_OF_DAY);
	
	if (millisecondi.length() == 1)
	millisecondi = "0" + millisecondi;
	if (secondi.length() == 1)
	secondi = "0" + secondi;
	if (minuti.length() == 1)
	minuti = "0" + minuti;
	if (ora.length() == 1)
	ora = "0" + ora;
	s=ora + ":" + minuti + ":" + secondi+":"+millisecondi;

	return s;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		 DataBase db=new DataBase("michele","");
		 stmt = db.getStatement();
		 while (true){
			 if(getOraAttuale().equals("09:00:10:100")){
				 		String countQuery = "SELECT COUNT(id) AS Totale FROM temperature;";
						rs = stmt.executeQuery(countQuery);
						rs.next();
						int id= rs.getInt("Totale"); 			
						System.out.println(id);
						id++;
						String insert = "INSERT INTO temperature (id,tempINT,tempEST) VALUES ("+id+",'"+preleva.getTempInterna()+"','"+preleva.getTempEsterna()+"')"; 
						stmt.executeUpdate(insert);
					 }
			 if(getOraAttuale().equals("13:00:10:100")){
			 		String countQuery = "SELECT COUNT(id) AS Totale FROM temperature;";
					rs = stmt.executeQuery(countQuery);
					rs.next();
					int id= rs.getInt("Totale"); 			
					System.out.println(id);
					id++;
					String insert = "INSERT INTO temperature (id,tempINT,tempEST) VALUES ("+id+",'"+preleva.getTempInterna()+"','"+preleva.getTempEsterna()+"')"; 
					stmt.executeUpdate(insert);
				 }
			 if(getOraAttuale().equals("17:00:10:100")){
			 		String countQuery = "SELECT COUNT(id) AS Totale FROM temperature;";
					rs = stmt.executeQuery(countQuery);
					rs.next();
					int id= rs.getInt("Totale"); 			
					System.out.println(id);
					id++;
					String insert = "INSERT INTO temperature (id,tempINT,tempEST) VALUES ("+id+",'"+preleva.getTempInterna()+"','"+preleva.getTempEsterna()+"')"; 
					stmt.executeUpdate(insert);
				 }
			 if(getOraAttuale().equals("21:00:10:100")){
			 		String countQuery = "SELECT COUNT(id) AS Totale FROM temperature;";
					rs = stmt.executeQuery(countQuery);
					rs.next();
					int id= rs.getInt("Totale"); 			
					System.out.println(id);
					id++;
					String insert = "INSERT INTO temperature (id,tempINT,tempEST) VALUES ("+id+",'"+preleva.getTempInterna()+"','"+preleva.getTempEsterna()+"')"; 
					stmt.executeUpdate(insert);
				 }
			 
		}		
	}
}
