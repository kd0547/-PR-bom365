package controller.support;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;


public class AdminSupportREGListAction{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자 후원내역 전체조회

		
		System.out.println("REGList 액션진입성공!!!!!");
		SupportREGDAO regdao = new SupportREGDAO();
		ActionForward forward = new ActionForward();
		
		// 페이징처리
		int totalCnt = regdao.AdminREGCntOne();    //전체 페이지값 가져오기
		
		String temp = request.getParameter("page");
		int page = 0;
		
		page = temp == null ? 1 : Integer.parseInt(temp); 
		
		int pageSize = 7;
		int endRow = page *7;
		int startRow = endRow -6;
		int startPage = (page -1) / pageSize*pageSize + 1;
		int endPage = startPage + pageSize -1;
		int totalPage = (totalCnt -1)/pageSize + 1;
				
		endPage = endPage > totalPage ? totalPage : endPage;
		
		//페이지네이션 파라미터 전달
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);	
		
		
		//금액 데이터 정리
		List<SupportREGDTO> AdminREGList = regdao.AdminREGSelectList(startRow, endRow); //전체 데이터 값 가져오기
		
		DecimalFormat df = new DecimalFormat("###,###,###");
		for (SupportREGDTO v : AdminREGList) {
			v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
		}
		
		//전체데이터 파라미터 전달
		request.setAttribute("AdminsupportREGList", AdminREGList);


		// Action 값 지정
		forward.setPath("adminSupportREGList.jsp");
		forward.setRedirect(false); // forward형식
		System.out.println("성공");

		return forward;
	}
}


