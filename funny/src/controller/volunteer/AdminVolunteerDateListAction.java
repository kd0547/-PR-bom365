package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import model.volunteer.VolunteerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminVolunteerDateListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		VolunteerDAO dao = new VolunteerDAO();
		String yyyyMMdd = request.getParameter("yyyyMMdd");
		System.out.println(yyyyMMdd);

		request.setAttribute("yyyyMMdd", yyyyMMdd);
		request.setAttribute("AMList", dao.selectDateAM(yyyyMMdd));
		request.setAttribute("PMList", dao.selectDatePM(yyyyMMdd));

		forward.setPath("adminVolunteerOne.jsp");
		forward.setRedirect(false);
		return forward;
	}
}