package controller.support;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;

public class SupportREGListCategoryAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//마이페이지,관리자페이지 정기후원 카테고리 Action
		
		System.out.println("action 들어옴");
		
		ActionForward forward = new ActionForward();
		SupportREGDAO regdao = new SupportREGDAO();

		
		// 각 버튼 별 카테고리로 분류하여 파라미터로 넘겨받는다
		String category = request.getParameter("category"); 
		
	
		// 금액순
		if (category.equals("REGamount")) {
			System.out.println("if 들어옴");
			List<SupportREGDTO> AdminsupportREGList = regdao.adminREGAmountSelectAll();
			System.out.println("AdminREGAmountSelectAll 값 받아옴: " + AdminsupportREGList);
			request.setAttribute("AdminsupportREGList",AdminsupportREGList);	   
			System.out.println("값넘김");
			    
			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportList.jsp");
					
		}
		
		
		
		/*// 기본상태가 최신순 이기 때문에 바로 board.do 로 넘겨줌
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
		}*/
		
		
		return forward; // 최종적으로 forward 를 반환한다
	}
}
