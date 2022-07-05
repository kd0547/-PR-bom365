package controller.board;

import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardListAction implements Action {

	// 게시판에 등록된 모든 글을 조회
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();

		// 전체 게시글 개수
		int totalCnt = dao.selectCnt();

		// 페이징 처리
		// 현재 넘겨받은 페이지
		String temp = request.getParameter("page");
		int page = 0;

		page = temp == null ? 1 : Integer.parseInt(temp);

		// 페이지 처리 [1][2]...[10] : 10개씩
		int pageSize = 10;

		// 1페이지 endRow = 10, 4 페이지 endRow = 40
		int endRow = page * 10;
		// 1페이지 startRow = 1, 4 페이지 startRow = 31
		int startRow = endRow - 9;

		// [1][2]...[10] : [1], [11][12]..[20] : [11]
		int startPage = (page - 1) / pageSize * pageSize + 1;
		// [1][2]...[10] : [10], [11][12]..[20] : [20]
		int endPage = startPage + pageSize - 1;
		int totalPage = (totalCnt - 1) / (endRow - startRow + 1) + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("boardList", dao.selectAll(startRow, endRow));
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward

		return forward;
	}
}
