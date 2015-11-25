package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.User;

/**
 * Servlet implementation class MainPage
 */
public class LogInServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**USERNAME
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logIn(request,response);
	}
	
	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(ParameterNames.USERNAME);
		String password = request.getParameter(ParameterNames.PASSWORD);
		User curUser = tryLogIn(username, password, false);
		if(null != curUser){
			request.getSession().setAttribute(ParameterNames.USER, curUser);
			redirect(request.getContextPath()+"/main",response);
		} else{
			curUser = tryLogIn(username, password, true);
			if (null != curUser) {
				request.getSession().setAttribute(ParameterNames.USER, curUser);
				redirect(request.getContextPath()+"/main",response);
			} else {
				request.getSession().setAttribute(ParameterNames.ERROR_MESSAGE, "Incorrect password. Try again.");
				forward("/login.jsp",request,response);
			}
		}
	}
	
	
	
	//TODO: Implement tryLogIn. Search the username in database, and compare the password.
	private User tryLogIn(String username, String password, boolean isManager){
		return User.login(username,password, isManager);
	}

}
