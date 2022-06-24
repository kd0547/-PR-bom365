package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BoardInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글을 작성
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setSupporter_id((String) session.getAttribute("supporter_id"));
		dto.setBoard_title(request.getParameter("board_title"));
		dto.setBoard_content(request.getParameter("board_content"));
		System.out.println("현재 dto: " + dto);
		dao.insert(dto);
		forward.setPath("boardDone.jsp");
		forward.setRedirect(true); // 넘겨야 할 데이터 X
		return forward;
	}
}
