package controller.supporter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterVO;


public class SignUpAction  implements Action{
	
	ActionForward forward = null;
	SupporterDAO supporterDAO = new SupporterDAO();
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SupporterVO supporterVO = new SupporterVO();
		
		
		supporterVO = createSupporterVO(request);
		
		
		if(supporterVO != null) {
			if(supporterDAO.insert(supporterVO)) {
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
	
	
	public SupporterVO createSupporterVO(HttpServletRequest request) {
		SupporterVO supporter = null;
		
		if(request != null) {
			supporter = new SupporterVO();
			
			supporter.setSupporter_id(request.getParameter("supporter_id"));
			supporter.setSupporter_name(request.getParameter("supporter_name"));
			supporter.setSupporter_password(request.getParameter("supporter_password"));
			supporter.setPhone_number(request.getParameter("phone_number"));
			supporter.setPost_code(request.getParameter("post_code"));
			supporter.setDetailed_address(request.getParameter("detailed_address"));
			
			return supporter;
		} 
		
		
		return supporter;
	}
	public String decodingName(String name) {
		
		
		try {
			return URLDecoder.decode(name,"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
}
