package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Card;
import edu.gatech.cs4400.FancyHotel.Model.User;

public class RemoveCardServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardNo = request.getParameter("card");
		Card.removeCard(cardNo);
		User curUser = (User) request.getSession().getAttribute(ParameterNames.USER);
		for(Card temp:curUser.getCards()){
			if(temp.getCardNo().equals(cardNo)){
				curUser.getCards().remove(temp);
			}
		}
		forward("/availability",request,response);
	}

}
