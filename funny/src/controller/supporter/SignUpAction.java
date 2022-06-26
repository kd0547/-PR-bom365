package controller.supporter;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;


public class SignUpAction  implements Action{
	
	ActionForward forward = null;
	SupporterDAO supporterDAO = new SupporterDAO();
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SupporterDTO supporterDTO;
		supporterDTO = createSupporterVO(request);
		
		if(supporterDTO != null) {
			if(supporterDAO.insert(supporterDTO)) {
				forward = new ActionForward();
				forward.setPath("signupDone.jsp");
				forward.setRedirect(true);
			} else {
				System.out.println("insert 실패");
			}
		} else {
			System.out.println("supporterVO 생성 실패");
		}
		
		return forward;
	}
	
	
	public SupporterDTO createSupporterVO(HttpServletRequest request) {
		SupporterDTO supporter = null;
		
				
		if(request != null) {
			supporter = new SupporterDTO();
			
			supporter.setSupporter_id(request.getParameter("supporter_id"));
			supporter.setSupporter_name(request.getParameter("supporter_name"));
			supporter.setSupporter_password(request.getParameter("supporter_password"));
			supporter.setPhone_number(request.getParameter("phone_number"));
			supporter.setPost_code(request.getParameter("post_code"));
			supporter.setDetailed_address(request.getParameter("detailed_address"));
			
			supporter.toString();
			
			return supporter;
		} 
		
		
		return supporter;
	}

}
