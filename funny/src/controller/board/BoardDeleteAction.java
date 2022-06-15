package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardDTO vo = new BoardDTO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));
		if (dao.delete(vo)) {
			System.out.println("삭제완료");
		}

		ActionForward forward = new ActionForward();
		forward.setPath("boardList.do");
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
