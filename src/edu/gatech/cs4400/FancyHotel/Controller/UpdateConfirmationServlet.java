package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Controller.BaseServlet;
import edu.gatech.cs4400.FancyHotel.Controller.ParameterNames;
import edu.gatech.cs4400.FancyHotel.Model.Reservation;
import edu.gatech.cs4400.FancyHotel.Model.User;

public class UpdateConfirmationServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			search(request);
			forward("/updateTwo",request,response);
		} catch(Exception e){
			request.setAttribute(ParameterNames.ERROR_MESSAGE, e.getMessage());
			forward("/updateOne",request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	private void search(HttpServletRequest request) throws Exception{
		String confirmationID = request.getParameter(ParameterNames.CONFIRMATIONID);
		if(!confirmationIDExist(confirmationID)){
			throw new Exception("Sorry, the confirmation ID:"+confirmationID+" is not exist.");
		}
		request.setAttribute(ParameterNames.RESERVATION, Reservation.getReservationByID(Integer.parseInt(confirmationID)));
		request.getSession().setAttribute(ParameterNames.RESERVATION, Reservation.getReservationByID(Integer.parseInt(confirmationID)));
	}
	
	
	//TODO: Implement this method
	private boolean confirmationIDExist(String email){
		return true;
	}
}
