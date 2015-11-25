package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

public class User {
	private String username = "Elice";
	private String password;
	private String userType = "user";
	
	
	public static boolean userExist(String username){
		String sql = "SELECT * "
				+ "FROM CUSTOMER"
				+ " WHERE CUSTOMER.Username ="+"'"+username+"'";
		JSONArray users = DatabaseConnector.query(sql);
		try {
			return users.length()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//TODO: return a user given the username.
	public static User login(String username, String password){
		//This is a wrong implementation.
		String sql = "SELECT * "
				+ "FROM CUSTOMER"
				+ " WHERE CUSTOMER.Username ="+"'"+username+"'";
		System.out.println(sql);
		JSONArray users = DatabaseConnector.query(sql);
		try {
			if(users.length()>0){
				String truePassword = users.getJSONObject(0).getString("Password");
				if(truePassword.equals(password)){
					return new User(username, password);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void CreateUser(String username, String password, String email){
		if(!userExist(username)){
			System.out.println("Creating customer!");
			String sql = 
					"INSERT INTO CUSTOMER (Username,Email, Password)"+
					"VALUES ('"+username+"', '"+email+"', '"+password+"')";
			DatabaseConnector.update(sql);
		}
	}
	
	//TODO: Create an instance of user in database when this constructor is called
	public User(String username,String password){
		this.username = username;
		this.password = password;
		this.userType = "user";
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String newUsername){
		this.username = newUsername;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	
	public String getUserType(){
		return this.userType;
	}
	
	public void setUserType(String userType){
		this.userType = userType;
	}
}
