package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.fabric.xmlrpc.base.Data;

import edu.gatech.cs4400.FancyHotel.Model.Room.LOCATION;

public class Reservation {
	private int reservationID;
	private Date start_date;
	private Date end_date;
	private String username;
	private String cardNo;
	private int review_no;
	private boolean isCanceled = false;
	
	public Reservation(int reservationID, Date start_date, Date end_date) {
		this.reservationID = reservationID;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	private List<ReserveRelationship> reserveRelationships = new ArrayList<>();
	
	
	//TODO: Query db and find the biggest reservation ID.
	public static int generateReservationID(){
		String sql = "SELECT MAX(ReservationID) AS MAX FROM RESERVATION";
		JSONArray jArray = DatabaseConnector.query(sql);
		try {
			JSONObject obj = jArray.getJSONObject(0);
			int currentMaxID = obj.getInt("MAX");
			return currentMaxID+1;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}
	
	public static Reservation getReservationByID(int ID){
		String sql = "SELECT * "
				+ "FROM RESERVATION"
				+ " WHERE RESERVATION.ReservationID ="+"'"+ID+"'";
		JSONArray reservationJSON = DatabaseConnector.query(sql);
		Reservation curRes = new Reservation(ID,null,null);
		try {
			if(reservationJSON.length()>0){
				JSONObject resJSONObj = reservationJSON.getJSONObject(0);
				curRes.setCardNo(resJSONObj.getString("CardNo"));
				curRes.setEnd_date((Date)resJSONObj.get("EndDate"));
				curRes.setStart_date((Date)resJSONObj.get("StartDate"));
				curRes.setUsername(resJSONObj.getString("Username"));
				curRes.isCanceled = resJSONObj.getBoolean("IsCanceled");
				curRes.setReserveRelationships(ReserveRelationship.getReserveRelationship(ID));
			} else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curRes;
	}
	
	public static void storeReservation(Reservation reservation){
		if(getReservationByID(reservation.getReservationID())==null){
			String sql = String.format("INSERT INTO RESERVATION VALUES("+
					"%d,"+
					"'%s',"
					+ "'%s',"
					+ "%d,"
					+ "%.2f,"
					+ "'%s',"
					+ "'%s')", 
					reservation.getReservationID(),
					reservation.getStart_date().toString(),
					reservation.getEnd_date().toString(),
					reservation.isCanceled()?1:0,
					reservation.getTotal_cost(),
					reservation.getCardNo(),
					reservation.getUsername());
			DatabaseConnector.update(sql);
			for(ReserveRelationship r : reservation.getReserveRelationships()){
			ReserveRelationship.storeReserveRelationship(r);
			}	
		}	
	}
	
	public static void updateReservation(Reservation reservation){
		if(getReservationByID(reservation.getReservationID())!=null){
			String sql = String.format("UPDATE RESERVATION SET "+
					"StartDate='%s',"+
					"EndDate='%s',"+
					"TotalCost=%.2f "+
					"WHERE ReservationID=%d"
					, 
					reservation.getStart_date().toString(),
					reservation.getEnd_date().toString(),
					reservation.getTotal_cost(),
					reservation.reservationID);
			DatabaseConnector.update(sql);
		}	
	}
	
//	private static void removeReservation(int ID){
//		String sql = String.format("DELETE * FROM RESERVATION, RESERVES WHERE "+
//									"ReservationID=%d", ID);
//		DatabaseConnector.update(sql);
//	}
	
	
	public static void cancelReservation(int ID){
		String sql = String.format("UPDATE RESERVATION SET IsCanceled=1 WHERE "+
				"ReservationID=%d", ID);
		DatabaseConnector.update(sql);
		sql = String.format("DELETE FROM RESERVES WHERE ReservationID=%d", ID);
		DatabaseConnector.update(sql);
	}


	public int getReservationID() {
		return reservationID;
	}


	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	public double getRefund(Date cancelDate){
		int dayDiff = getDayDifference(cancelDate,this.start_date);
		if(dayDiff<=1){
			return 0;
		} else if(dayDiff<=3){
			return getTotal_cost()*0.8;
		} else{
			return getTotal_cost();
		}
	}


	public double getTotal_cost() {
		double costPerDay = 0;
		for(ReserveRelationship r : this.reserveRelationships){
			Room tempRoom = r.getRoom();
			costPerDay += tempRoom.getCost();
			if(r.isHasExtraBed()){
				costPerDay += tempRoom.getCostPerExtraBed();
			}
		}
		return getDurationInDays()*costPerDay;
	}
	
	private int getDurationInDays(){
		return getDayDifference(this.start_date,this.end_date);
	}
	
	private int getDayDifference(Date day1, Date day2){
		return (int) TimeUnit.MILLISECONDS.toDays((day2.getTime() - day1.getTime()));
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getReview_no() {
		return review_no;
	}


	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}


	public List<ReserveRelationship> getReserveRelationships() {
		return reserveRelationships;
	}


	public void setReserveRelationships(List<ReserveRelationship> reserveRelationships) {
		this.reserveRelationships = reserveRelationships;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
}
