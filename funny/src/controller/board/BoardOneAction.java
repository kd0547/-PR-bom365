package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardSet;
import model.board.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardOneAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDTO vo = new BoardDTO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));
		BoardDAO dao = new BoardDAO();
		BoardSet boardOne = dao.selectOne(vo);
		request.setAttribute("boardOne", boardOne);
		ActionForward forward = new ActionForward();
		forward.setPath("boardOne.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
