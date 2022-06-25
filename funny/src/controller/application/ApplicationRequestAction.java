package controller.application;

import controller.Action;
import controller.ActionForward;
import model.animal.AnimalDTO;
import model.application.ApplicationDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationRequestAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDTO dto = new AnimalDTO();
		ApplicationDAO dao = new ApplicationDAO();

		dto.setAnimal_number(Integer.parseInt(request.getParameter("animal_number")));
		dto = dao.selectAnimal(dto);
		
		request.setAttribute("animal", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("adoptionRequest.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
