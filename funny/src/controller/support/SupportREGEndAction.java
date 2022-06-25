package controller.support;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;

 
public class SupportREGEndAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//정기후원종료신청
		
		ActionForward forward = new ActionForward();
		SupportREGDAO regdao = new SupportREGDAO();
		
		 //세션에서 ID값 꺼내오기
	    HttpSession session = request.getSession();
		String supporter_id = (String)session.getAttribute("supporter_id");
	    System.out.println(supporter_id);
	    
	    
	    regdao.setEnd(supporter_id);
		
		forward.setRedirect(false); //forward방식
		forward.setPath("supportEnd.jsp");
		
		System.out.println("supporter_id: " + request);

		return forward;
	}
	
	
	
	
}