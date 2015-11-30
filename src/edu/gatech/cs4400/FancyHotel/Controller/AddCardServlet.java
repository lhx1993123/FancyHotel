package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Card;
import edu.gatech.cs4400.FancyHotel.Model.DatabaseConnector;
import edu.gatech.cs4400.FancyHotel.Model.User;

public class AddCardServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cardNo = request.getParameter("cardNumber");
		String nameOnCard = request.getParameter("nameonCard");
		Date expDate = Date.valueOf(request.getParameter("expireDate"));
		String cvv = request.getParameter("cvv");
		User curUser = (User) request.getSession().getAttribute(ParameterNames.USER);
		Card newCard = new Card(cardNo,cvv,expDate,nameOnCard,curUser.getUsername());
		curUser.getCards().add(newCard);
		Card.storeCard(newCard);
		forward("/availability",request,response);
	}
}
