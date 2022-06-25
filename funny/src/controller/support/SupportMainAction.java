package controller.support;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;

public class SupportMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 정기후원 중 중복신청 불가능

		SupportREGDAO regdao = new SupportREGDAO();
		ActionForward forward = new ActionForward();

		System.out.println("SupportRegularEndCheck진입성공");

		// 세션에서 ID값 꺼내오기
		HttpSession session = request.getSession();
		String supporter_id = (String) session.getAttribute("supporter_id");

		 //로그인 안하고 정기후원 페이지 입장할 때 대비
		 if(supporter_id == null) {
			 supporter_id = "";
		 }
		
		List<SupportREGDTO> dto = regdao.SupportREGEndCheck(supporter_id);

		// 정기후원기록이 복수인 사람 대비
		if (dto.size() > 1) {
			request.setAttribute("regular_end", dto.get(dto.size() - 1));
		} else {
			request.setAttribute("regular_end", dto);
		}

		// 파라미터로 값 전달
		forward.setRedirect(false); // forward방식
		forward.setPath("support.jsp");

		return forward;
	}

}
