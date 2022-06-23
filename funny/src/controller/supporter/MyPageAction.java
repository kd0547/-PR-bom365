package controller.supporter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterVO;

public class MyPageAction implements Action{
	
	
	private ActionForward forward = new ActionForward();
	private SupporterDAO supporterDAO = new SupporterDAO();
	private SupporterVO supporterVO = null ;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id= request.getSession().getAttribute("supporter_id").toString();
		
		if(id != null) {
			supporterVO = supporterDAO.SupporterIdInfo(id);
			
			if(supporterVO != null) {
				request.setAttribute("userInfo", supporterVO);

			} else {
				//에러 제어 코드 
				//어디로 보낼지 생각 안남 
			}
			
			
		} else {
			//에러 제어 코드 
			//어디로 보낼지 생각 안 남 
			
		}
		// 문제 없으면 실행 	
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
	
		return forward;
	}
	
	

}
