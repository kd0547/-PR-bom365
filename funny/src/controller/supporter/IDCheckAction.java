package controller.supporter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;


public class IDCheckAction extends HttpServlet implements Action{
	SupporterDAO idCheck = new SupporterDAO();
	

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
	
		response.getWriter().print(idCheck(id));
		return null;
	}
	
	// ID 중복 검사
		// true : 값 있음 , false : 값 없음
		public boolean idCheck(String id) {
			
			if(idCheck.idCheck(id)) {
				return true;
			} else {
				return false;
			}
		}
}
