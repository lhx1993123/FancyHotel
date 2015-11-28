package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReserveRelationship {
	private Room room;
	private boolean hasExtraBed;
	private Reservation reservation;
	
	public ReserveRelationship(Room room, boolean hasExtraBed){
		this.room = room;
		this.hasExtraBed = hasExtraBed;
	}
	
	public static List<ReserveRelationship> getReserveRelationship(int reservationID){
		ArrayList<ReserveRelationship> list = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM RESERVES"
				+ " WHERE RESERVES.ReservationID ="+"'"+reservationID+"'";
		JSONArray reserveRelationshipJSONArray = DatabaseConnector.query(sql);
		try{
			for(int i=0;i<reserveRelationshipJSONArray.length();i++){
				JSONObject temp = reserveRelationshipJSONArray.getJSONObject(i);
				int roomNo = temp.getInt("RoomNo");
				Room.LOCATION location = Room.LOCATION.valueOf(temp.getString("Location"));
				Room curRoom = Room.getRoomByRoomNumberAndLocation(roomNo, location);
				boolean extraBed = temp.getBoolean("ExtraBed");
				ReserveRelationship curReserve = 
						new ReserveRelationship(curRoom, extraBed);
				list.add(curReserve);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	private static boolean reserveExist(ReserveRelationship reserve){
		String sql = "SELECT * "
				+ "FROM RESERVES"
				+ " WHERE RESERVES.ReservationID ="+"'"+reserve.getReservation().getReservationID()+"'"
				+ " AND RESERVES.RoomNo="+reserve.getRoom().getRoomNumber()
				+ " AND RESERVES.Location='"+reserve.getRoom().getLocation()+"'";
		JSONArray reserveRelationshipJSONArray = DatabaseConnector.query(sql);
		return reserveRelationshipJSONArray.length()>0;
	}
	
	public static void storeReserveRelationship(ReserveRelationship reserve){
		if(reserveExist(reserve)){
			removeReserveRelationship(reserve);
		}
		String sql = String.format("INSERT INTO RESERVES VALUES ("+
				"%d,%d,'%s',%d)",
				reserve.getReservation().getReservationID(),
				reserve.getRoom().getRoomNumber(),
				reserve.getRoom().getLocation().toString(),
				reserve.isHasExtraBed()?1:0);
		DatabaseConnector.update(sql);
	}
	
	public static void removeReserveRelationship(ReserveRelationship reserve){
		String sql = "DELETE * "
				+ "FROM RESERVES"
				+ " WHERE RESERVES.ReservationID ="+"'"+reserve.getReservation().getReservationID()+"'"
				+ " AND RESERVES.RoomNo="+reserve.getRoom().getRoomNumber()
				+ " AND RESERVES.Location='"+reserve.getRoom().getLocation()+"'";
		DatabaseConnector.update(sql);
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
