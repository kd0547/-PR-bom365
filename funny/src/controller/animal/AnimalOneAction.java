package controller.animal;

import controller.Action;
import controller.ActionForward;
import model.animal.AnimalDAO;
import model.animal.AnimalDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnimalOneAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnimalDTO dto = new AnimalDTO();
		dto.setAnimal_number(Integer.parseInt(request.getParameter("animal_number")));
		AnimalDAO dao = new AnimalDAO();
		dto = dao.selectOne(dto);
		request.setAttribute("animalOne", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("animalOne.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
