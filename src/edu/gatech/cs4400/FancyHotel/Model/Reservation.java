package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
	private int reservationID;
	private Date start_date;
	private Date end_date;
	private int total_cost;
	private String username;
	private int review_no;
	
	public Reservation(int reservationID, Date start_date, Date end_date) {
		this.reservationID = reservationID;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	private List<ReserveRelationship> reserveRelationships;
	
	
	public static Reservation getReservationByID(String ID){
		Reservation res = new Reservation(10245, new Date(), new Date());
		ReserveRelationship rr1 = new ReserveRelationship();
		rr1.setReservation(res);
		rr1.setRoom(new Room("1","Atlanta",Room.CATEGORY.FAMILY,3,100.0,50.0));
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


	public int getTotal_cost() {
		return total_cost;
	}


	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
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
