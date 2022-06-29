package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VolunteerDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerDAO dao = new VolunteerDAO();
		VolunteerDTO vo = new VolunteerDTO();

		vo.setVolunteer_number(Integer.parseInt(request.getParameter("volunteer_number")));
		if (dao.delete(vo)) {
			System.out.println("삭제완료");
		}

		ActionForward forward = new ActionForward();
		forward.setPath("mypage.me");
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
