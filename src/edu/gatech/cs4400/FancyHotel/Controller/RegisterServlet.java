package edu.gatech.cs4400.FancyHotel.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gatech.cs4400.FancyHotel.Model.User;

public class RegisterServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			register(request);
			redirect(request.getContextPath()+"/main",response);
		} catch(Exception e){
			request.setAttribute(ParameterNames.ERROR_MESSAGE, e.getMessage());
			forward("/newUser",request,response);
		}
	}

	private boolean register(HttpServletRequest request) throws Exception{
		String email = request.getParameter(ParameterNames.EMAIL);
		String username = request.getParameter(ParameterNames.USERNAME);
		String password = request.getParameter(ParameterNames.PASSWORD);
		String passwordAgain = request.getParameter(ParameterNames.PASSWORDAGAIN);
		if(emailExist(email)){
			throw new Exception("Sorry, the email address:"+email+" has been used already.");
		}
		if(userExist(username)){
			throw new Exception("Sorry, the username:"+username+" already exists.");
		}
		if(!password.equals(passwordAgain)){
			throw new Exception("Sorry, the passwords don't match.");
		}
		User.CreateUser(username, password, email);
		User user  = new User(username, password);
		request.getSession().setAttribute(ParameterNames.USER, user);
		return user!=null;
	}
	
	
	private User createNewUser(String username, String password){
		return new User(username, password);
	}
	
	//TODO: Implement emailExist.
	private boolean emailExist(String email){
		return false;
	}
	
	
	//TODO: Implement userExist.
	private boolean userExist(String username){
		return User.userExist(username);
	}

}
