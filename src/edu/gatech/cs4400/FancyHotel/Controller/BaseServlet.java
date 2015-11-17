package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.gatech.cs4400.FancyHotel.Controller.ParameterNames;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	protected void redirect(String url, HttpServletResponse aResponse) throws IOException {
	    String urlWithSessionID = aResponse.encodeRedirectURL(url);
	    aResponse.sendRedirect( urlWithSessionID );
	}
	
	protected void forward(String pageName, HttpServletRequest aRequest, HttpServletResponse aResponse) throws ServletException, IOException {
	    RequestDispatcher dispatcher = aRequest.getRequestDispatcher(pageName);
	    dispatcher.forward(aRequest, aResponse);
	}
	
	public boolean isLoggedIn(HttpServletRequest request){
		return null != request.getSession().getAttribute(ParameterNames.USER);
	}
	
}
