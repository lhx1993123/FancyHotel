package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.Date;

public class Card {
	private String cardNo;
	private String cvv;
	private Date expDate;
	private String name;
	private String username;
	
	public Card(String cardNo, String cvv, Date expDate, String name, String username){
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.expDate = expDate;
		this.name = name;
		this.username = username;
	}
	
	public static void storeCard(Card card){
		String sql = String.format("INSERT INTO PAYMENT_INFORMATION VALUES ("+
				"'%s','%s','%s','%s','%s')",
				card.getCardNo(),
				card.getCvv(),
				card.getExpDate().toString(),
				card.getName(),
				card.getUsername());
		DatabaseConnector.update(sql);
	}
	
	public static void removeCard(String cardNo){
		String sql = String.format("DELETE * FROM PAYMENT_INFORMATION "+
								"WHERE Card_no='%s'", cardNo);
		DatabaseConnector.update(sql);
	}
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
