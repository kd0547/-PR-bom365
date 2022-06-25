package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VolunteerInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		VolunteerDAO dao = new VolunteerDAO();
		VolunteerDTO dto = new VolunteerDTO();

		dto.setSupporter_id((String) session.getAttribute("supporter_id"));
		dto.setVolunteer_date(request.getParameter("volunteer_date"));
		dto.setVolunteer_time(request.getParameter("volunteer_time"));

		dao.insert(dto);
		
		forward.setPath("volunteerDone.jsp");
		forward.setRedirect(true); // 넘겨야 할 데이터 X
		return forward;
	}
}
