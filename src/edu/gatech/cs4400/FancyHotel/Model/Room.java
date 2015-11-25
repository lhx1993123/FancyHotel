package edu.gatech.cs4400.FancyHotel.Model;

public class Room {
	
	public enum LOCATION{ATLANTA, CHARLOTTE, SAVANNAH, ORLANDO, MIAMI};
	private String roomNumber;
	private LOCATION location;
	public enum CATEGORY{STANDARD, FAMILY, SUITE};
	private Room.CATEGORY roomCategory;
	private int numberOfPeople;
	private double cost;
	private double costPerExtraBed;
	
	
	//TODO: Implement this.
	public static Room getRoomByRoomNumberAndLocation(String roomNumber, LOCATION location){
		return new Room(roomNumber,location, Room.CATEGORY.FAMILY,4,100,50);
	}
	
	public Room(String roomNumber, LOCATION location, Room.CATEGORY category, int numberOfPeople,
			double cost, double costPerExtraBed){
		this.roomNumber = roomNumber;
		this.location = location;
		this.roomCategory = category;
		this.numberOfPeople = numberOfPeople;
		this.cost = cost;
		this.costPerExtraBed = costPerExtraBed;
	}
	
	
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumer) {
		this.roomNumber = roomNumer;
	}
	public LOCATION getLocation() {
		return location;
	}
	public void setLocation(LOCATION location) {
		this.location = location;
	}
	public Room.CATEGORY getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(Room.CATEGORY roomCategory) {
		this.roomCategory = roomCategory;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCostPerExtraBed() {
		return costPerExtraBed;
	}
	public void setCostPerExtraBed(double costPerExtraBed) {
		this.costPerExtraBed = costPerExtraBed;
	}
}
