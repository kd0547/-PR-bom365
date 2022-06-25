package controller.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;

public class MytableAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			//후원내역조회Action
			
			ActionForward forward = new ActionForward();
			System.out.println("MytableAction입장완료");
			SupportREGDAO regdao = new SupportREGDAO();
			
			 //세션에서 ID값 꺼내오기
		    HttpSession session = request.getSession();
			String supporter_id = (String)session.getAttribute("supporter_id");
		    System.out.println("아이디값: " + supporter_id);
			
		    //dao에 id값 전달
		    regdao.selectAll(supporter_id);

		    //프론트로 값 전달
		    request.setAttribute("MytableREGList",regdao.selectAll(supporter_id));
		    System.out.println("값전달완료->성공");
		    
			forward.setRedirect(false);//forward방식
			forward.setPath("mypage.jsp");
					
					
		return forward;
	}

}
