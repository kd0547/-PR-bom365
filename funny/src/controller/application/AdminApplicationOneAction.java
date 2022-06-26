package controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.application.ApplicationDAO;
import model.application.ApplicationDTO;

public class AdminApplicationOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ApplicationDAO apdao = new ApplicationDAO();
		ApplicationDTO apdto = new ApplicationDTO();
		
		apdto.setApplication_number(Integer.parseInt(request.getParameter("application_number")));
		
		request.setAttribute("application", apdao.selectOne(apdto));
		forward.setRedirect(false);
		forward.setPath("adminApplicationOne.jsp");
		
		return forward;
	}

}










