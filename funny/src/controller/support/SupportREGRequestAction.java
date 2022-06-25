package controller.support;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;

import model.supportRequest.SupportREGRequestDAO;
import model.supportRequest.SupportREGRequestDTO;
 
public class SupportREGRequestAction implements Action{
    
	 @Override
	   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
	    SupportREGRequestDAO regdao = new SupportREGRequestDAO();
	    SupportREGRequestDTO regdto = new SupportREGRequestDTO();
	    ActionForward forward = new ActionForward();
		 
		 //세션에서 ID값 꺼내오기
		 HttpSession session = req.getSession();
		 String supporter_id = (String)session.getAttribute("supporter_id");
		
		//값담기
		 regdto.setSupporter_id(supporter_id);
		 regdto.setRegular_bank(req.getParameter("regular_bank"));
		 regdto.setRegular_account(req.getParameter("regular_account"));
		 regdto.setRegular_amount(Integer.parseInt(req.getParameter("regular_amount")));
		 regdto.setRegular_date(Integer.parseInt(req.getParameter("regular_date")));
	    
 
        if(regdao.supportREGRequest(regdto)) {        
            forward.setRedirect(true);
            forward.setPath(req.getContextPath() + "/supportDone.jsp");
        } else {                
            forward.setRedirect(true);
            forward.setPath(req.getContextPath() + "/index.jsp" );
        }
        
        return forward;
    }
}
 
