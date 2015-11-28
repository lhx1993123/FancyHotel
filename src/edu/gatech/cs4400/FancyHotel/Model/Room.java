package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Room {
	
	public enum LOCATION{ATLANTA, CHARLOTTE, SAVANNAH, ORLANDO, MIAMI};
	private int roomNumber;
	private LOCATION location;
	public enum CATEGORY{STANDARD, FAMILY, SUITE};
	private Room.CATEGORY roomCategory;
	private int numberOfPeople;
	private double cost;
	private double costPerExtraBed;
	
	
	public static Room getRoomByRoomNumberAndLocation(int roomNumber, LOCATION location){
		String sql = String.format("SELECT * FROM ROOM "+
				"WHERE Location='%s' "+
				"AND RoomNo=%d",location.toString(), roomNumber);
		System.out.println(sql);
		JSONArray rooms = DatabaseConnector.query(sql);
		Room returnRooms = null;
		try {
			JSONObject curRoom = rooms.getJSONObject(0);
			Room newRoom = new Room(curRoom.getInt("RoomNo"),Room.LOCATION.valueOf(curRoom.getString("Location").toUpperCase().trim()),
				Room.CATEGORY.valueOf(curRoom.getString("RoomCategory").toUpperCase().trim()),
				curRoom.getInt("NoPeople"),curRoom.getDouble("Cost"),curRoom.getDouble("CostExtraBed"));
			returnRooms = newRoom;
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnRooms;
	}
	
	public Room(int roomNumber, LOCATION location, Room.CATEGORY category, int numberOfPeople,
			double cost, double costPerExtraBed){
		this.roomNumber = roomNumber;
		this.location = location;
		this.roomCategory = category;
		this.numberOfPeople = numberOfPeople;
		this.cost = cost;
		this.costPerExtraBed = costPerExtraBed;
	}
	
	
	public static List<Room> getAvailableRooms(Room.LOCATION location, Date startdate, Date enddate){
		String sql = String.format("SELECT * FROM ROOM "+
									"WHERE Location='%s' "+
									"AND NOT EXISTS ("+
									"SELECT * FROM "+
									"RESERVATION NATURAL JOIN RESERVES "+
									"WHERE ROOM.RoomNo=RoomNo AND ((Startdate >= %s AND Startdate<= %s) "+
									"OR (Enddate>=%s AND Enddate <= %s)))",
									location.toString(), startdate.toString().replace("-", ""),
									enddate.toString().replace("-", ""),
									startdate.toString().replace("-", ""), 
									enddate.toString().replace("-", ""));
		System.out.println(sql);
		JSONArray rooms = DatabaseConnector.query(sql);
		ArrayList<Room> returnRooms = new ArrayList<Room>();
		try {
			for(int i=0;i<rooms.length();i++){
				JSONObject curRoom = rooms.getJSONObject(i);
				Room newRoom = new Room(curRoom.getInt("RoomNo"),Room.LOCATION.valueOf(curRoom.getString("Location").toUpperCase().trim()),
						Room.CATEGORY.valueOf(curRoom.getString("RoomCategory").toUpperCase().trim()),
						curRoom.getInt("NoPeople"),curRoom.getDouble("Cost"),curRoom.getDouble("CostExtraBed"));
				returnRooms.add(newRoom);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnRooms;
	}
	
	
	public static List<Room> checkRoomsStillAvailable(Room.LOCATION location, Date startdate, Date enddate, int confirmationID){
		String sql = String.format("SELECT ROOM.* "
				+ "FROM RESERVES NATURAL JOIN RESERVATION NATURAL JOIN ROOM "
				+ "WHERE ReservationID=%d AND Location='%s' AND NOT EXISTS "
				+ "(SELECT * "
				+ "FROM RESERVES NATURAL JOIN RESERVATION NATURAL JOIN ROOM "
				+ "WHERE ReservationID<>%d AND Location='%s' "
				+ "AND ((Startdate >= %s AND Startdate<= %s) OR (Enddate>=%s AND Enddate <= %s)))",
									confirmationID,
									location.toString(),
									confirmationID,
									location.toString(),
									startdate.toString().replace("-", ""),
									enddate.toString().replace("-", ""),
									startdate.toString().replace("-", ""),
									enddate.toString().replace("-", ""));
		System.out.println(sql);
		JSONArray rooms = DatabaseConnector.query(sql);
		ArrayList<Room> returnRooms = new ArrayList<Room>();
		try {
			for(int i=0;i<rooms.length();i++){
				JSONObject curRoom = rooms.getJSONObject(i);
				Room newRoom = new Room(curRoom.getInt("RoomNo"),Room.LOCATION.valueOf(curRoom.getString("Location").toUpperCase().trim()),
						Room.CATEGORY.valueOf(curRoom.getString("RoomCategory").toUpperCase().trim()),
						curRoom.getInt("NoPeople"),curRoom.getDouble("Cost"),curRoom.getDouble("CostExtraBed"));
				returnRooms.add(newRoom);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnRooms;
	}
	
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumer) {
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
