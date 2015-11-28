package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.sql.Date;
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
		Date newstartdate = Date.valueOf(request.getParameter("newstartdate"));
		Date newenddate = Date.valueOf(request.getParameter("newenddate"));
		Reservation reservation = (Reservation) request.getSession().getAttribute(ParameterNames.RESERVATION);
		System.out.print(reservation==null);
		Room.LOCATION location = reservation.getReserveRelationships().get(0).getRoom().getLocation();
		List<Room> rooms = Room.checkRoomsStillAvailable(location, newstartdate, newenddate, reservation.getReservationID());
		if(rooms.size()==reservation.getReserveRelationships().size()){
			reservation.setStart_date(newstartdate);
			reservation.setEnd_date(newenddate);
			request.getSession().setAttribute("newReservation", reservation);
			request.getSession().setAttribute("rooms", rooms);
			forward("/updateThree",request,response);
		} else{
			request.setAttribute(ParameterNames.ERROR_MESSAGE, 
					"Rooms not available. Do you want to cancel the reservation?");
			forward("/updateThree",request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
