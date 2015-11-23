package edu.gatech.cs4400.FancyHotel.Model;

public class ReserveRelationship {
	private Room room;
	private boolean hasExtraBed;
	private Reservation reservation;
	
	public ReserveRelationship(Room room, boolean hasExtraBed, Reservation reservation){
		this.room = room;
		this.hasExtraBed = hasExtraBed;
		this.reservation = reservation;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public boolean isHasExtraBed() {
		return hasExtraBed;
	}
	public void setHasExtraBed(boolean hasExtraBed) {
		this.hasExtraBed = hasExtraBed;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
