package controller.supporter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

public class MyPageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		SupporterDAO dao = new SupporterDAO();
		SupporterDTO dto = new SupporterDTO() ;
		
		HttpSession session = request.getSession(); // spring 식 session 을 받는법
		String id= (String) session.getAttribute("supporter_id");
		
		dto.setSupporter_id(id);

		dto = dao.SupporterIdInfo(dto);
		request.setAttribute("userInfo", dto);
		
		// 문제 없으면 실행 	
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
	
		return forward;
	}
	
	

}
