package controller.supporter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

public class WithdrawalAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = null; 
		
		SupporterDTO dto = new SupporterDTO();
		SupporterDAO dao = new SupporterDAO();
		
		dto.setSupporter_id(request.getParameter("supporter_id"));
		dto.setSupporter_password(request.getParameter("supporter_password"));
		boolean result = dao.delete(dto);
		
		if(result == true) {
			//세션 삭제 
			HttpSession session = request.getSession();
			session.invalidate();
			
			forward = new ActionForward(); 
			forward.setPath("withdrawalDone.jsp");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('패스워드가 일치하지 않습니다.');history.go(-1);</script>");
		}
		return forward;
	}
}
