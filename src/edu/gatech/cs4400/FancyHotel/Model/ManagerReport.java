package edu.gatech.cs4400.FancyHotel.Model;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ManagerReport {
	private String month;
	private Room.LOCATION location;
	private int numOfRes;
	private	Room.CATEGORY category;
	private int revenue;
	
	
	public static ArrayList<ManagerReport> getReservationReport() {
		String sql = "SELECT StartDate, Location, COUNT(*) AS Count "
					+ "FROM RESERVATION NATURAL JOIN RESERVES NATURAL JOIN ROOM "
					+ "GROUP BY month(StartDate), Location";
		
		JSONArray reservations = DatabaseConnector.query(sql);
		ArrayList<ManagerReport> returnReservations = new ArrayList<>();
		try {
			for(int i=0;i<reservations.length();i++){
				JSONObject curReservation = reservations.getJSONObject(i);
				ManagerReport newMR = new ManagerReport(getMonth(Integer.parseInt(curReservation.get("StartDate").toString().split("-")[1])),
															Room.LOCATION.valueOf(curReservation.getString("Location").toUpperCase().trim()),
															curReservation.getInt("Count"), null, 0);						
				returnReservations.add(newMR);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnReservations;
	}
	
	public static ArrayList<ManagerReport> getPopRoomCat() {
		String sql = "SELECT StartDate, RoomCategory, Location, COUNT(*) AS Count "
					+ "FROM RESERVATION NATURAL JOIN RESERVES NATURAL JOIN ROOM "
					+ "GROUP BY month(StartDate), RoomCategory, Location";
	
		JSONArray reservations = DatabaseConnector.query(sql);
		ArrayList<ManagerReport> returnPopRoomCats = new ArrayList<>();
		try {
			for(int i=0;i<reservations.length();i++){
				JSONObject curReservation = reservations.getJSONObject(i);
				ManagerReport newMR = new ManagerReport(getMonth(Integer.parseInt(curReservation.get("StartDate").toString().split("-")[1])),
															Room.LOCATION.valueOf(curReservation.getString("Location").toUpperCase().trim()),
															curReservation.getInt("Count"),
															Room.CATEGORY.valueOf(curReservation.getString("RoomCategory").toUpperCase().trim()),
															0);						
				returnPopRoomCats.add(newMR);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnPopRoomCats;
	}
	
	public static ArrayList<ManagerReport> getRevenueReport() {
		String sql = "SELECT StartDate, Location, SUM(TotalCost) AS Total "
					+ "FROM RESERVATION NATURAL JOIN RESERVES NATURAL JOIN ROOM "
					+ "GROUP BY month(StartDate), Location";
	
		JSONArray reservations = DatabaseConnector.query(sql);
		ArrayList<ManagerReport> returnRevenueReport = new ArrayList<>();
		try {
			for(int i=0;i<reservations.length();i++){
				JSONObject curReservation = reservations.getJSONObject(i);
				ManagerReport newMR = new ManagerReport(getMonth(Integer.parseInt(curReservation.get("StartDate").toString().split("-")[1])),
															Room.LOCATION.valueOf(curReservation.getString("Location").toUpperCase().trim()),
															0, null, curReservation.getInt("Total"));						
				returnRevenueReport.add(newMR);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnRevenueReport;
	}
	
	public ManagerReport(String month, Room.LOCATION location, int numOfRes, Room.CATEGORY category, int revenue) {
		this.month = month;
		this.location = location;
		this.numOfRes = numOfRes;
		this.category = category;
		this.revenue = revenue;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Room.LOCATION getLocation() {
		return location;
	}

	public void setLocation(Room.LOCATION location) {
		this.location = location;
	}

	public int getNumOfRes() {
		return numOfRes;
	}

	public void setNumOfRes(int numOfRes) {
		this.numOfRes = numOfRes;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
	private static String getMonth(int m) {
		return new DateFormatSymbols().getMonths()[m-1];
	}

	public Room.CATEGORY getCategory() {
		return category;
	}

	public void setCategory(Room.CATEGORY category) {
		this.category = category;
	}
}
