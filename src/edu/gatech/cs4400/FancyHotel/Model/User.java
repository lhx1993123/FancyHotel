package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	private String username = "Elice";
	private String password;
	private String userType = "user";
	private List<Card> cards = new ArrayList<>();
	
	
	public static boolean userExist(String username, boolean isManager){
		String sql;
		if (!isManager) {
			sql = "SELECT * "
					+ "FROM CUSTOMER"
					+ " WHERE CUSTOMER.Username ="+"'"+username+"'";
		} else {
			sql = "SELECT * "
					+ "FROM MANAGEMENT"
					+ " WHERE MANAGEMENT.Username ="+"'"+username+"'";
		}
		JSONArray users = DatabaseConnector.query(sql);
		try {
			return users.length()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
		
	public static User login(String username, String password, boolean isManager){
		String sql;
		if (!isManager) {
			sql = "SELECT * "
					+ "FROM CUSTOMER"
					+ " WHERE CUSTOMER.Username ="+"'"+username+"'";
		} else {
			sql = "SELECT * "
					+ "FROM MANAGEMENT"
					+ " WHERE MANAGEMENT.Username ="+"'"+username+"'";
		}
		System.out.println(sql);
		JSONArray users = DatabaseConnector.query(sql);
		String cardSql = String.format("SELECT * "
						+ "FROM PAYMENT_INFORMATION"
						+ " WHERE Username='%s'",username);
		JSONArray jsoncards = DatabaseConnector.query(cardSql);
		try {
			if(users.length()>0){
				String truePassword = users.getJSONObject(0).getString("Password");
				if(truePassword.equals(password)){
					if (!isManager) {
						User user = new User(username, password);
						for(int i=0;i<jsoncards.length();i++){
							JSONObject temp = jsoncards.getJSONObject(i);
							Card newCard = new Card();
							newCard.setCardNo(temp.getString("CardNo"));
							newCard.setCvv(temp.getString("CVV"));
							newCard.setExpDate((Date)temp.get("ExpDate"));
							newCard.setName(temp.getString("Name"));
							user.cards.add(newCard);
						}
						return user;
					} else {
						User user = new User(username, password);
						user.userType = "manager";
						return user;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void CreateUser(String username, String password, String email){
		if(!userExist(username, false)){
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

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
