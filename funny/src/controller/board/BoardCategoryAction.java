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
import java.util.ArrayList;

public class BoardCategoryAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		// 각 버튼 별 카테고리로 분류하여 파라미터로 넘겨받는다
		String category = request.getParameter("category"); 
		
		// 카테고리는 최신순, 댓글, 내글보기 순으로 세가지가 존재
		// 카테고리 값 : 내글보기/mine, 최신순/recent, 댓글순/comment
		
		BoardDAO dao = new BoardDAO();
		
		// 내글보기
		if (category.equals("mine")) {
			HttpSession session = request.getSession();
			BoardDTO vo = new BoardDTO();
			// 현재 로그인된 uid 를 통해 select
			vo.setSupporter_id((String) session.getAttribute("supporter_id"));
			ArrayList<BoardDTO> boardList = dao.selectMine(vo);
			request.setAttribute("boardList", boardList);

			forward.setPath("boardList.jsp");
			forward.setRedirect(false); // 보내야할 데이터가 있기때문에 forward
		}
		
		// 기본상태가 최신순 이기 때문에 바로 board.do 로 넘겨줌
		else if (category.equals("recent")) {
			forward.setPath("boardList.do");
			forward.setRedirect(true); // 넘겨줄 데이터 없으니 sendRedirect
		}
		
		// 댓글 순
		else if (category.equals("comment")) {
			ArrayList<BoardDTO> boardList = dao.selectComCnt();
			request.setAttribute("boardList", boardList);

			forward.setPath("boardList.jsp");
			forward.setRedirect(true); // 보내야할 데이터가 있기때문에 forward
		}
		
		return forward; // 최종적으로 forward 를 반환한다
	}
}
