package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		BoardDAO dao = new BoardDAO();
		BoardDTO vo = new BoardDTO();
		vo.setBoard_number(Integer.parseInt(request.getParameter("board_number"))); // view로부터 받아온 글번호를 vo 객체에 저장
		vo.setBoard_title(request.getParameter("board_title"));
		vo.setBoard_content(request.getParameter("board_content"));
		dao.update(vo); 

		// 수정 후 상세게시물로 이동
		forward.setPath("boardOne.do?board_number=" + vo.getBoard_number());
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
