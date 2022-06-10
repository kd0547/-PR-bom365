package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardSet;
import model.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdatePageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));
		BoardDAO dao = new BoardDAO();
		BoardSet boardDetail = dao.selectOne(vo);
		request.setAttribute("boardDetail", boardDetail);
		ActionForward forward = new ActionForward();
		forward.setPath("boardUpdate.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
