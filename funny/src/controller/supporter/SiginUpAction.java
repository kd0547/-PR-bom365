package controller.supporter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;

@WebServlet("/signup")
public class SiginUpAction extends HttpServlet implements Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		execute(req,resp);
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("supporter_id"));
		System.out.println(request.getParameter("supporter_name"));
		System.out.println(request.getParameter("supporter_password"));
		System.out.println(request.getParameter("phone_number"));
		System.out.println(request.getParameter("post_code"));
		System.out.println(request.getParameter("detailed_address"));
		
		ActionForward forward = null;
		forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("signupDone.jsp");
		return forward;
	}
	
}
