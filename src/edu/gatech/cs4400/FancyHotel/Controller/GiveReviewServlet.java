package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.Review;

/**
 * Servlet implementation class GiveReviewServlet
 */
@WebServlet("/GiveReviewServlet")
public class GiveReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			review(request);
			redirect(request.getContextPath()+"/giveReview",response);
		} catch(Exception e){
			request.setAttribute(ParameterNames.ERROR_MESSAGE, e.getMessage());
			forward("/giveReview",request,response);
		}
	}

	private boolean review(HttpServletRequest request) throws Exception {
		String location = request.getParameter(ParameterNames.LOCATION);
		String rating = request.getParameter(ParameterNames.RATING);
		String comment = request.getParameter(ParameterNames.COMMENT);
		Review review = generateReview(location, comment, rating, "lhx", 12345);
		request.getSession().setAttribute(ParameterNames.COMMENT, review);
		return review!=null;
	}
	
	private Review generateReview(String location, String comment, String rating, String username, int reviewNo){
		return new Review(location, comment, rating, username, reviewNo);
	}
}
