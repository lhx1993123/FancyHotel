package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import edu.gatech.cs4400.FancyHotel.Model.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchRoomsServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String location = request.getParameter("location");
		Date startdate = Date.valueOf(request.getParameter("startdate"));
		Date enddate = Date.valueOf(request.getParameter("enddate"));
		List<Room> rooms = searchRooms(Room.LOCATION.valueOf(location), startdate, enddate);
		request.getSession().setAttribute("startdate", startdate);
		request.getSession().setAttribute("enddate", enddate);
		request.getSession().setAttribute(ParameterNames.LOCATION, location);
		request.getSession().setAttribute("rooms", rooms);
		forward("/chooseRooms",request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	//TODO: Implement DB query
	private List<Room> searchRooms(Room.LOCATION location, Date startdate, Date enddate){
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room("1",location,Room.CATEGORY.FAMILY,3,100.0,50.0));
		rooms.add(new Room("2",location,Room.CATEGORY.STANDARD,2,90.0,40.0));
		rooms.add(new Room("3",location,Room.CATEGORY.SUITE,2,101.0,59.0));
		return rooms;
	}
	
}
