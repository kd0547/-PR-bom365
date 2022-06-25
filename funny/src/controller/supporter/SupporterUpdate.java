package controller.supporter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterVO;

public class SupporterUpdate implements Action{
	
	ActionForward forward = null;
	SupporterDAO supporterDAO = new SupporterDAO();
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SupporterVO supporterVO = new SupporterVO();
		
		
		
		supporterVO.setSupporter_id(request.getSession().getAttribute("supporter_id").toString());
		supporterVO.setSupporter_name(request.getParameter("supporter_name"));
		supporterVO.setSupporter_password(request.getParameter("supporter_password"));
		supporterVO.setPhone_number(request.getParameter("phone_number"));
		supporterVO.setPost_code(request.getParameter("post_code"));
		supporterVO.setDetailed_address(request.getParameter("detailed_address"));
		
		if(supporterDAO.SupporterUpdate(supporterVO)) {
			forward = new ActionForward();
			
			forward.setPath("mypage.me");
			forward.setRedirect(true);
		} else {
			// 에러 페이지 
			forward = null;
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스크립트 printwriter
		// forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
		out.println("<script>alert('변경 완료');history.go(-1);</script>"); 
		
		return null;
	}

}
