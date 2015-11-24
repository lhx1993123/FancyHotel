package edu.gatech.cs4400.FancyHotel.Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	private static final String ACCOUNT = "cs4400_Group_51";
	private static final String KEY = "gH88BNAR";
	
	
	public static ResultSet query(String sql) {
		 Connection con = null;
		 ResultSet rs = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection("jdbc:mysql://academicmysql.cc.gatech.edu/"+ACCOUNT,
					 ACCOUNT,KEY);
			 if(!con.isClosed()){
				 Statement s = con.createStatement();
				 rs = s.executeQuery(sql);
			 }
		 } catch(Exception e) {
			 System.err.println("Exception: " + e.getMessage());
		 } finally {
			 try {
			 if(con != null)
				 con.close();
			 } catch(SQLException e) {}
		 }
		 return rs;
	}
	
	public static void update(String sql) {
		 Connection con = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection("jdbc:mysql://academicmysql.cc.gatech.edu/"+ACCOUNT,
					 ACCOUNT,KEY);
			 if(!con.isClosed()){
				 Statement s = con.createStatement();
				 s.executeUpdate(sql);
			 }
		 } catch(Exception e) {
			 System.err.println("Exception: " + e.getMessage());
		 } finally {
			 try {
			 if(con != null)
				 con.close();
			 } catch(SQLException e) {}
		 }
	}
	
}
