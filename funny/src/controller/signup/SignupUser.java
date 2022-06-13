package controller.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterVO;

@WebServlet("/signup")
public class SignupUser extends HttpServlet implements Action{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SupporterDAO supporterDAO = new SupporterDAO();
	SupporterVO supporterVO = new SupporterVO();
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	public void signUp() {
		
	}
	
}
