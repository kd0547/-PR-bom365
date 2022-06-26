package controller.support;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportTEMDAO;
import model.support.SupportTEMDTO;

public class SupportTEMInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		// 일시후원신청

		SupportTEMDAO temdao = new SupportTEMDAO();
		SupportTEMDTO temdto = new SupportTEMDTO();
		ActionForward forward = new ActionForward();

		// 세션에서 ID값 꺼내오기
		HttpSession session = req.getSession();
		String supporter_id = (String) session.getAttribute("supporter_id");
		// 넘어온 파라미터값 가공
		String temporary_amount = (String) req.getParameter("temporary_amount");
		temporary_amount = temporary_amount.replace(",", "");
		System.out.println("파라미터값: " + temporary_amount);

		// 값넣기
		temdto.setSupporter_id(supporter_id);
		temdto.setTemporary_amount(temporary_amount);
		System.out.println("파라미터값: " + temporary_amount);

		if (temdao.insert(temdto)) {
			forward.setRedirect(true); // 성공 //Redirect방식
			forward.setPath("supportDone.jsp");
		} else {
			forward.setRedirect(true); // 실패 //Redirect방식
			forward.setPath("support.sp");
		}

		return forward;

	}
}
