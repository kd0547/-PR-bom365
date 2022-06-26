package controller.support;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;
import model.support.SupportTEMDAO;
import model.support.SupportTEMDTO;

public class SupportAdminListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자 후원내역 조회

		SupportREGDAO regdao = new SupportREGDAO();
		SupportTEMDAO temdao = new SupportTEMDAO();

		ActionForward forward = new ActionForward();

		System.out.println("AdminSupportListAction진입성공");

		// dao데이터받아옴
		List<SupportREGDTO> AdminsupportREGList = regdao.AdminREGSelectAll();
		List<SupportTEMDTO> AdminsupportTEMList = temdao.AdminTEMSelectAll();

		System.out.println("dao데이터받음");

		// 파라미터로 값 넣음
		request.setAttribute("AdminsupportREGList", AdminsupportREGList);
		request.setAttribute("AdminsupportTEMList", AdminsupportTEMList);

		System.out.println("파라미터 값 넣기 성공");

		// Action 값 지정
		forward.setPath("adminSupportList.jsp");
		forward.setRedirect(false); // forward형식
		System.out.println("성공");

		return forward;

	}
}

/*
 * //페이징처리 //전체 정기후원 개수 int totalCnt = regdao.getSupportREGRequestCnt();
 * 
 * //페이징처리,현제 넘겨받은 페이지 String temp = request.getParameter("page"); int page = 0;
 * 
 * page = temp == null ? 1 : Integer.parseInt(temp);
 * 
 * //페이지처리 [1],[2],10개씩 int pageSize = 8;
 * 
 * //1페이지 endrow =10 2페이지 endrow =40 int endRow = page *8; //1페이지 startRow = 1,
 * 4페이지startRow =31 int startRow = endRow -9;
 * 
 * //[1],[2]...[10] int startPage = (page -1) /pageSize*pageSize +1;
 * //[1].[2]...[10] ...[11].[12]...[20] int endPage= startPage + pageSize -1;
 * int totalPage = (totalCnt -1) / pageSize +1;
 * 
 * System.out.println("endRow : " + endRow); System.out.println("startRow : " +
 * startRow); System.out.println("startPage : " + startPage);
 * System.out.println("endPage : " + endPage); System.out.println("totalPage : "
 * + totalPage); System.out.println("---------------------------------");
 * 
 * endPage = endPage > totalPage ? totalPage : endPage;
 * 
 * request.setAttribute("totalPage", totalPage); request.setAttribute("nowPage",
 * page); request.setAttribute("startPage", startPage);
 * request.setAttribute("endPage", endPage);
 * 
 * request.setAttribute("totalCnt", totalCnt); request.setAttribute("boardList",
 * regdao.getSupportList(startRow, endRow));
 */
