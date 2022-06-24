package controller.animal;

import controller.Action;
import controller.ActionForward;
import model.animal.AnimalDAO;
import model.animal.AnimalDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AnimalListAction implements Action {

	// 게시판에 등록된 모든 글을 조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDAO dao = new AnimalDAO();
		List<AnimalDTO> animalList = dao.selectAll(); // dao 에서 조회된 데이터들을 받아옴
		request.setAttribute("animalList", animalList);
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("animalList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward

		return forward;
	}
}
