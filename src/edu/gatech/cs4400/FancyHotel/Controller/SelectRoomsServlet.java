package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Reservation;
import edu.gatech.cs4400.FancyHotel.Model.ReserveRelationship;
import edu.gatech.cs4400.FancyHotel.Model.Room;

public class SelectRoomsServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buttonType = request.getParameter("submit");
		if(buttonType!=null){
			//submit reservation
			
		} else{
			//check price
			Reservation r = getReservation(request);
			double cost = r.getTotal_cost();
			request.setAttribute("cost", String.valueOf(cost));
			forward("/chooseRooms",request,response);
		}
	}
	
	
	//TODO: Store the reservation into DB
	private void submitReservation(Reservation reservation){
		
	}
	
	private Reservation getReservation(HttpServletRequest request){
		Date startdate = (Date)request.getSession().getAttribute("startdate");
		Date enddate = (Date)request.getSession().getAttribute("enddate");
		String[] rooms = request.getParameterValues("selectedRooms");
		String[] extraBeds = request.getParameterValues("selectedExtraBeds");
		String location = (String) request.getSession().getAttribute(ParameterNames.LOCATION);
		Reservation r = new Reservation(Reservation.getLargestReservationID(),startdate,enddate);
		if(rooms!=null){
			for(String room : rooms){
				Room tempRoom = Room.getRoomByRoomNumberAndLocation(room, Room.LOCATION.valueOf(location));
				boolean hasExtra = false;
				if(extraBeds!=null){
					for(String extra : extraBeds){
						if(extra.equals(room)){
							hasExtra = true;
						}
					}
				}
				ReserveRelationship relationship = new ReserveRelationship(tempRoom, hasExtra,r);
				r.getReserveRelationships().add(relationship);
			}
		}
		return r;
	}
	
	

}