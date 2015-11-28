package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.*;

import java.sql.*;

public class DatabaseConnector {
	private static final String ACCOUNT = "cs4400_Group_51";
	private static final String KEY = "gH88BNAR";
	private static Connection con;
	
	
	public static JSONArray query(String sql) {
		 Connection con = null;
		 JSONArray jsonArray = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/"+ACCOUNT,
					 ACCOUNT,KEY);
			 if(!con.isClosed()){
				 Statement s = con.createStatement();
				 System.out.println(sql);
				 ResultSet rs = s.executeQuery(sql);
				 jsonArray = convert(rs);
			 }
		 } catch(Exception e) {
			 System.err.println("Exception: " + e.getMessage()+e.getClass());
			 e.printStackTrace();
		 } finally {
			 try {
			 if(con != null)
				 con.close();
			 } catch(SQLException e) {}
		 }
		 return jsonArray;
	}
	
	public static void update(String sql) {
		 Connection con = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/"+ACCOUNT,
					 ACCOUNT,KEY);
			 if(!con.isClosed()){
				 Statement s = con.createStatement();
				 System.out.println(sql);
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
	
	
 private static JSONArray convert( ResultSet rs ) throws SQLException, JSONException
  {
    JSONArray json = new JSONArray();
    ResultSetMetaData rsmd = rs.getMetaData();

    while(rs.next()) {
      int numColumns = rsmd.getColumnCount();
      JSONObject obj = new JSONObject();

      for (int i=1; i<numColumns+1; i++) {
        String column_name = rsmd.getColumnName(i);

        if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
         obj.put(column_name, rs.getArray(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
         obj.put(column_name, rs.getInt(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
         obj.put(column_name, rs.getBoolean(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
         obj.put(column_name, rs.getBlob(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
         obj.put(column_name, rs.getDouble(column_name)); 
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
         obj.put(column_name, rs.getFloat(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
         obj.put(column_name, rs.getInt(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
         obj.put(column_name, rs.getNString(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
         obj.put(column_name, rs.getString(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
         obj.put(column_name, rs.getInt(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
         obj.put(column_name, rs.getInt(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
         obj.put(column_name, rs.getDate(column_name));
        }
        else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
        obj.put(column_name, rs.getTimestamp(column_name));   
        }
        else{
         obj.put(column_name, rs.getObject(column_name));
        }
      }

      json.put(obj);
    }

    return json;
  }
}
