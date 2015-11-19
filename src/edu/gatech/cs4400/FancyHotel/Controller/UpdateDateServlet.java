package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Reservation;
import edu.gatech.cs4400.FancyHotel.Model.Room;

public class UpdateDateServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentstartdate = request.getParameter("currentstartdate");
		String currentenddate = request.getParameter("currentenddate");
		String newstartdate = request.getParameter("newstartdate");
		String newenddate = request.getParameter("newenddate");
		
		Reservation reservation = (Reservation) request.getSession().getAttribute(ParameterNames.RESERVATION);
		System.out.print(reservation==null);
		String location = reservation.getReserveRelationships().get(0).getRoom().getLocation();
		List<Room> rooms = searchRooms(currentstartdate, currentenddate, newstartdate, newenddate, location);
		request.setAttribute("rooms", rooms);
		forward("/updateThree",request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	//TODO: Implement DB query
	private List<Room> searchRooms(String location, String currentstartdate, String currentenddate, String newstartdate, String newenddate){
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room("1",location,Room.CATEGORY.FAMILY,3,100.0,50.0));
		rooms.add(new Room("2",location,Room.CATEGORY.STANDARD,2,90.0,40.0));
		rooms.add(new Room("3",location,Room.CATEGORY.SUITE,2,101.0,59.0));
		return rooms;
	}

}
