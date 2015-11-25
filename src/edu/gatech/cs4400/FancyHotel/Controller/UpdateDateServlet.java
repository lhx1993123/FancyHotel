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
		Room.LOCATION location = reservation.getReserveRelationships().get(0).getRoom().getLocation();
		List<Room> rooms = searchRooms(location, currentstartdate, currentenddate, newstartdate, newenddate);
		request.setAttribute("rooms", rooms);
		forward("/updateThree",request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	//TODO: Implement DB query
	private List<Room> searchRooms(Room.LOCATION location, String currentstartdate, String currentenddate, String newstartdate, String newenddate){
		ArrayList<Room> rooms = new ArrayList<Room>();
		return rooms;
	}

}
