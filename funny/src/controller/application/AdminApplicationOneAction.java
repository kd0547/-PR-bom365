package controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.application.ApplicationDAO;

public class AdminApplicationOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ApplicationDAO apdao = new ApplicationDAO();
		
		int application_number = Integer.parseInt( request.getParameter("application_number") );
		
		request.setAttribute("application", apdao.selectOne(application_number));
		forward.setRedirect(false);
		forward.setPath("adminApplicationOne.jsp");
		
		return forward;
	}

}










