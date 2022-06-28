package controller.support;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;

 
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
	    
		// 정기후원 중 중복신청 불가능
		List<SupportREGDTO> supportREGdto = regdao.supportREGEndCheck(supporter_id);

		// 정기후원기록이 복수인 사람 대비
		if (supportREGdto.size() > 1) {
			session.setAttribute("regular_end", supportREGdto.get(supportREGdto.size() - 1));
			System.out.println("종료일 = "+session.getAttribute("regular_end"));
		} else if(supportREGdto.size() ==1 ) {
			session.setAttribute("regular_end", supportREGdto.get(0));
			System.out.println("종료일 = "+session.getAttribute("regular_end"));
		} else {
			session.setAttribute("regular_end", supportREGdto);
			System.out.println("종료일 = "+session.getAttribute("regular_end"));
		}
	    
		forward.setRedirect(true); //forward방식
		forward.setPath("supportEnd.jsp");
		
		System.out.println("supporter_id: " + request);

		return forward;
	}
}