package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.Board_commentDAO;
import model.board.Board_commentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board_commentDAO dao = new Board_commentDAO();
		Board_commentDTO vo = new Board_commentDTO();
		vo.setComment_number(request.getParameter("comment_number"));
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));
		
		if (dao.delete(vo)) {
			System.out.println("삭제완료");
		}

		ActionForward forward = new ActionForward();
		forward.setPath("boardOne.do?board_number=" + request.getParameter("board_number"));
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
