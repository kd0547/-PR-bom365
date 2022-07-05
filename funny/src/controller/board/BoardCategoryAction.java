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

public class BoardCategoryAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		BoardDTO dto = new BoardDTO();
		// 현재 로그인된 uid 를 통해 select
		String supporter_id = (String) session.getAttribute("supporter_id");
		if(supporter_id != null) {
			dto.setSupporter_id(supporter_id);
		}
		
		// 각 버튼 별 카테고리로 분류하여 파라미터로 넘겨받는다
		String category = request.getParameter("category"); 
		request.setAttribute("category", category);
		
		// 카테고리는 최신순, 댓글, 내글보기 순으로 세가지가 존재
		// 카테고리 값 : 내글보기/mine, 댓글순/comment
		
		BoardDAO dao = new BoardDAO();
		
		int totalCnt = 0;
		// 전체 게시글 개수
		if(category.equals("mine")){
			totalCnt = dao.selectMineCnt(dto);
		} else if(category.equals("comment")) {
			totalCnt = dao.selectCnt();
		}
		
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
		
		// 내글보기
		if (category.equals("mine")) {
			request.setAttribute("boardList", dao.selectMine(dto, startRow, endRow));
		}
		
		// 댓글 순
		else if (category.equals("comment")) {
			request.setAttribute("boardList", dao.selectComCnt(startRow, endRow));
		}
		
		forward.setPath("boardList.jsp");
		forward.setRedirect(false); // 보내야할 데이터가 있기때문에 forward
		return forward; // 최종적으로 forward 를 반환한다
	}
}
