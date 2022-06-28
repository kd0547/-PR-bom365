package controller.supporter;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LogInAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null; // 로그인 되지 않았다면 null 이 되도록
		HttpSession session = request.getSession(); // spring 식 session 을 받는법

		// 로그인
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////
		SupporterDAO dao = new SupporterDAO();
		SupporterDTO dto = new SupporterDTO();

		String supporter_id = request.getParameter("supporter_id");
		String supporter_password = request.getParameter("supporter_password");
		dto.setSupporter_id(supporter_id);
		dto.setSupporter_password(supporter_password);
		SupporterDTO data = dao.login(dto);

		// 만약 아이디, 비밀번호가 동일하다면
		if (data != null) {
			session.setAttribute("supporter_id", data.getSupporter_id());
			session.setAttribute("supporter_name", data.getSupporter_name()); // "000님 환영합니다"에 쓰임
			System.out.println(data.getSupporter_name());

			// 로그인 시 이전 페이지의 URL을 저장한다.
			/*
			 * 이전 페이지의 검증이 필요할 것 같음
			 */
			String previousURL = (String) session.getAttribute("PREVIOUS");
			System.out.println("test: " + previousURL);
			forward = new ActionForward();
			if (previousURL != null) {
				forward.setPath(previousURL);
			} else {
				forward.setPath("main.do");
			}

			forward.setRedirect(true); // 세션에 저장하였기 때문에 넘겨줘야할 데이터가 없음
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter(); // 스크립트 printwriter
			// forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
			out.println("<script>alert('해당 아이디는 존재하지 않습니다!');history.go(-1);</script>");
		}

		// 정기후원 종료일 조회
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////
		// 정기후원 중 중복신청 불가능
		SupportREGDAO regdao = new SupportREGDAO();
		List<SupportREGDTO> supportREGdto = regdao.supportREGEndCheck(supporter_id);

		// 정기후원기록이 복수인 사람 대비
		if (supportREGdto.size() > 1) {
			session.setAttribute("regular_end", supportREGdto.get(supportREGdto.size() - 1));
			System.out.println("종료일 = " + session.getAttribute("regular_end"));
		} else if (supportREGdto.size() == 1) {
			session.setAttribute("regular_end", supportREGdto.get(0));
			System.out.println("종료일 = " + session.getAttribute("regular_end"));
		} else {
			session.setAttribute("regular_end", supportREGdto);
			System.out.println("종료일 = " + session.getAttribute("regular_end"));
		}

		return forward;
	}
}
