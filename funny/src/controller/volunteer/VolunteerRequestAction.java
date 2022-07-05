package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import model.volunteer.VolunteerCnt;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class VolunteerRequestAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VolunteerCnt cnt = new VolunteerCnt();
		VolunteerDAO dao = new VolunteerDAO();

		cnt.setYyyyMMdd(request.getParameter("yyyyMMdd"));
		cnt.setCntAM(Integer.parseInt(request.getParameter("cntAM")));
		cnt.setCntPM(Integer.parseInt(request.getParameter("cntPM")));

		request.setAttribute("volCnt", cnt);
		
		HttpSession session = request.getSession();
		VolunteerDTO dto = new VolunteerDTO();
		dto.setSupporter_id((String) session.getAttribute("supporter_id"));
		dto.setVolunteer_date(cnt.getYyyyMMdd());
		
		dto.setVolunteer_time("오전");
		request.setAttribute("checkAM", dao.selectSupporter(dto));
		
		dto.setVolunteer_time("오후");
		request.setAttribute("checkPM", dao.selectSupporter(dto));
		
		ActionForward forward = new ActionForward();
		forward.setPath("volunteerRequest.jsp");
		forward.setRedirect(false);
		return forward;
	}
}