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
import edu.gatech.cs4400.FancyHotel.Model.User;

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
		try{
			if(buttonType!=null){
				//submit reservation
				Reservation r;
				r = getReservation(request);
				
				submitReservation(r);
				request.getSession().setAttribute("reservation", r);
				redirect(request.getContextPath()+"/confirmation",response);
			} else{
				//check price
				Reservation r = getReservation(request);
				double cost = r.getTotal_cost();
				request.setAttribute("cost", String.valueOf(cost));
				forward("/chooseRooms",request,response);
			}
		} catch(Exception e){
			request.setAttribute(ParameterNames.ERROR_MESSAGE, e.getMessage());
			forward("/chooseRooms",request,response);
		}
	}
	
	
	private void submitReservation(Reservation reservation){
		Reservation.storeReservation(reservation);
	}
	
	protected Reservation getReservation(HttpServletRequest request) throws Exception{
		Date startdate = (Date)request.getSession().getAttribute("startdate");
		Date enddate = (Date)request.getSession().getAttribute("enddate");
		String[] rooms = request.getParameterValues("selectedRooms");
		String[] extraBeds = request.getParameterValues("selectedExtraBeds");
		String cardNo = request.getParameter("card");
		if(cardNo==null || cardNo.isEmpty()){
			throw new Exception("No card selected");
		}
		User curUser = (User) request.getSession().getAttribute(ParameterNames.USER);
//		curUser = User.login(curUser.getUsername(),curUser.getPassword(), false);
//		request.getSession().setAttribute(ParameterNames.USER, curUser);
		String location = (String) request.getSession().getAttribute(ParameterNames.LOCATION);
		Reservation r = new Reservation(Reservation.generateReservationID(),startdate,enddate);
		r.setCardNo(cardNo);
		r.setUsername(curUser.getUsername());
		if(rooms!=null){
			for(String room : rooms){
				Room tempRoom = Room.getRoomByRoomNumberAndLocation(Integer.parseInt(room), Room.LOCATION.valueOf(location.toUpperCase().trim()));
				boolean hasExtra = false;
				if(extraBeds!=null){
					for(String extra : extraBeds){
						if(extra.equals(room)){
							hasExtra = true;
						}
					}
				}
				ReserveRelationship relationship = new ReserveRelationship(tempRoom, hasExtra);
				relationship.setReservation(r);
				r.getReserveRelationships().add(relationship);
			}
		}
		return r;
	}
}