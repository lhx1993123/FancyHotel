package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Review;
import edu.gatech.cs4400.FancyHotel.Model.Room;

/**
 * Servlet implementation class ViewReviewServlet
 */
@WebServlet("/ViewReviewServlet")
public class ViewReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String location = request.getParameter("location").toUpperCase();
		List<Review> reviews = getReviews(Review.LOCATION.valueOf(location));
		if (reviews.isEmpty()) {
			request.getSession().setAttribute(ParameterNames.ERROR_MESSAGE, "No review currently.");
		} else {
			request.setAttribute(ParameterNames.RATING, location);
			request.setAttribute("reviews", reviews);
			forward("/viewReview",request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	private List<Review> getReviews(Review.LOCATION location) {
		List<Review> reviews = Review.getReviewsByLocation(location);
		return reviews;
	}

}
