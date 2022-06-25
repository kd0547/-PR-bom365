package controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.application.ApplicationDAO;
import model.application.ApplicationDTO;

public class ApplicationInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ApplicationDAO dao = new ApplicationDAO();
		ApplicationDTO dto = new ApplicationDTO();
		
		HttpSession session = request.getSession(); // spring 식 session 을 받는법
		dto.setSupporter_id((String)session.getAttribute("supporter_id"));
		dto.setAnimal_number(Integer.parseInt(request.getParameter("animal_number")));
		dto.setApplication_title(request.getParameter("application_title"));
		dto.setApplication_content(request.getParameter("application_content"));
		dao.insert(dto);
		
		forward.setPath("adoptionDone.jsp");
		forward.setRedirect(true); // 넘겨야 할 데이터 X
		return forward;
	}

}
