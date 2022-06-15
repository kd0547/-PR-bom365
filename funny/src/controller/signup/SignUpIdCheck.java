package controller.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.supporter.SupporterDAO;

@WebServlet("/idOverlap")
public class SignUpIdCheck extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SupporterDAO idCheck = new SupporterDAO();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		
		
		
		resp.getWriter().print(idCheck(id));
	
	}
	
	
	
	
	// ID 중복 검사
	// true : 값 있음 , false : 값 없음
	public boolean idCheck(String id) {
		String T_String = "kd0547";
		System.out.println(id);
		if(id.equals(T_String)) {
			return true;
		} else {
			return false;
		}
	}
}
