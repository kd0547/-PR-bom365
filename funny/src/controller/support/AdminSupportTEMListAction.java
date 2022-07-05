package controller.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import controller.ActionForward;
import model.support.SupportTEMDAO;

public class AdminSupportTEMListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자 일시후원내역 조회


		System.out.println("SupportAdminTEMListAction 액션진입성공!!!!!");
		
		SupportTEMDAO temdao = new SupportTEMDAO();
		ActionForward forward = new ActionForward();
		
		// 전체 게시글 개수
		int totalCnt = temdao.AdminTEMCntOne();
		
		// 페이징 처리
		// 현재 넘겨받은 페이지
		String temp = request.getParameter("page");
		int page = 0;
		
		page = temp == null ? 1 : Integer.parseInt(temp); 
		
		// 페이지 처리 [1][2]...[10] : 10개씩
		int pageSize = 7;
		
		// 1페이지 endRow = 10, 4 페이지 endRow = 40
		int endRow = page *7;
		// 1페이지 startRow = 1, 4 페이지 startRow = 31
		int startRow = endRow -6;
		
		// [1][2]...[10] : [1], [11][12]..[20] : [11]
		int startPage = (page -1) / pageSize*pageSize + 1;
		// [1][2]...[10] : [10], [11][12]..[20] : [20]
		int endPage = startPage + pageSize -1;
		int totalPage = (totalCnt -1)/pageSize + 1;
		
		System.out.println("endRow : " + endRow);
		System.out.println("startRow : " + startRow);
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("totalPage : " + totalPage);
		System.out.println("---------------------------------");
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("AdminsupportTEMList", temdao.AdminTEMSelectList(startRow, endRow));
		System.out.println("값가져옴: " + temdao.AdminTEMSelectList(startRow, endRow));


		System.out.println("파라미터 값 넣기 성공");

		// Action 값 지정
		forward.setPath("adminSupportTEMList.jsp");
		forward.setRedirect(false); // forward형식
		System.out.println("성공");

		return forward;


	}
}

