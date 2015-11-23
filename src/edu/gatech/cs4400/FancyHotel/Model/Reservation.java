package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int reservationID;
	private Date start_date;
	private Date end_date;
	private String username;
	private int review_no;
	
	public Reservation(int reservationID, Date start_date, Date end_date) {
		this.reservationID = reservationID;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	private List<ReserveRelationship> reserveRelationships = new ArrayList<>();
	
	
	//TODO: Query db and find the biggest reservation ID.
	public static int getLargestReservationID(){
		Random r = new Random();
		return r.nextInt(10000000);
	}
	
	public static Reservation getReservationByID(String ID){
		Reservation res = new Reservation(10245, null, null);
		ReserveRelationship rr1 =
				new ReserveRelationship(new Room("1","Atlanta",Room.CATEGORY.FAMILY,3,100.0,50.0),false,res);
		ArrayList<ReserveRelationship> rrs = new ArrayList<ReserveRelationship>();
		rrs.add(rr1);
		res.setReserveRelationships(rrs);
		return res;
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
		return (int) TimeUnit.MILLISECONDS.toDays((this.end_date.getTime() - this.start_date.getTime()));
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
	
}
