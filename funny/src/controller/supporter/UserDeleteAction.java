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

public class UserDeleteAction implements Action{
	
	SupporterDAO dao = new SupporterDAO();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null; 
		
		String request_id = request.getParameter("supporter_id");
		String request_pwd = request.getParameter("supporter_password");
		
		int result = dao.SupporterDelete(request_id,request_pwd);
		
		
		if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('패스워드가 일치하지 않습니다.');history.go(-1);</script>");
		
		} else if(result == -1) {
			forward = new ActionForward();
			forward.setPath("main.jsp");
			forward.setRedirect(true);
		} else {
			//세션 삭제 
			HttpSession session = request.getSession();
			session.invalidate();
			
			forward = new ActionForward();
			forward.setPath("withdrawalDone.jsp");
			forward.setRedirect(true);
		}
		
		
		
		return forward;
	}

}
