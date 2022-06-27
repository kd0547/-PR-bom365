package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.Board_commentDAO;
import model.board.Board_commentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommentInsertAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글을 작성
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		Board_commentDAO dao = new Board_commentDAO();
		Board_commentDTO vo = new Board_commentDTO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number")));
		vo.setSupporter_id((String)session.getAttribute("supporter_id"));
		vo.setComment_content(request.getParameter("comment_content"));
		System.out.println("현재 vo: " + vo);
		dao.insert(vo);
		forward.setPath("boardDetail.do?board_number=" + request.getParameter("board_number"));
		forward.setRedirect(true); // 넘겨야 할 데이터 X
		System.out.println(forward.getPath());
		return forward;
	}
}
