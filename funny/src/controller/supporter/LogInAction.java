package controller.supporter;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogInAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = null; // 로그인 되지 않았다면 null 이 되도록
		SupporterDAO dao = new SupporterDAO();
		SupporterVO vo = new SupporterVO();
		
		String supporter_id = request.getParameter("supporter_id");
		String supporter_password = request.getParameter("supporter_password");
		vo.setSupporter_id(supporter_id);
		vo.setSupporter_password(supporter_password);
		SupporterVO data = dao.login(vo);
		System.out.println(data);
		
		// 만약 아이디, 비밀번호가 동일하다면
		if (data != null) { 
			HttpSession session = request.getSession(); // spring 식 session 을 받는법
			session.setAttribute("supporter_id", data.getSupporter_id());
			session.setAttribute("supporter_name", data.getSupporter_name()); // "000님 환영합니다"에 쓰임
			System.out.println(data.getSupporter_name());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true); // 세션에 저장하였기 때문에 넘겨줘야할 데이터가 없음
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			// forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
			out.println("<script>alert('해당 아이디는 존재하지 않습니다!');history.go(-1);</script>"); 
		}

		return forward;
	}
}
