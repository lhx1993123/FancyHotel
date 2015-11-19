package edu.gatech.cs4400.FancyHotel.Model;

public class User {
	private String username = "Elice";
	private String password;
	private String userType = "user";
	
	
	//TODO: return a user given the username.
	public static User getUser(String username, String password){
		//This is a wrong implementation.
		
		return new User(username, password);
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
