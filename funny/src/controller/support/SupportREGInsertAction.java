package controller.support;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;

public class SupportREGInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		// 정기후원신청

		SupportREGDAO regdao = new SupportREGDAO();
		SupportREGDTO regdto = new SupportREGDTO();
		ActionForward forward = new ActionForward();

		// 세션에서 ID값 꺼내오기
		HttpSession session = req.getSession();
		String supporter_id = (String) session.getAttribute("supporter_id");

		// 금액에 ,포함 변환
		String regular_amount = req.getParameter("regular_amount");
		regular_amount = regular_amount.replace(",", "");
		System.out.println("파라미터값: " + regular_amount);

		String regular_paymentDate = req.getParameter("regular_paymentDate");
		String regular_date = null;

		// 값담기
		regdto.setSupporter_id(supporter_id);
		regdto.setRegular_bank(req.getParameter("regular_bank"));
		regdto.setRegular_account(req.getParameter("regular_account"));
		regdto.setRegular_amount(regular_amount);
		regdto.setRegular_paymentDate(regular_paymentDate);

		Calendar cal = Calendar.getInstance();
		int thisY = cal.get(Calendar.YEAR);
		int thisM = cal.get(Calendar.MONTH) + 1;
		int thisD = cal.get(Calendar.DATE);
		if (thisD < Integer.parseInt(regular_paymentDate)) {
			regular_date = thisY + "/" + String.format("%02d", thisM) + "/" + regular_paymentDate;
		} else {
			if (thisM == 12) {
				regular_date = (thisY + 1) + "/" + "01" + "/" + regular_paymentDate;
			} else {
				regular_date = thisY + "/" + String.format("%02d", thisM+1) + "/" + regular_paymentDate;
			}
		}

		regdto.setRegular_date(regular_date);
		System.out.println("값담김: " + regdto);

		if (regdao.insert(regdto)) {
			System.out.println("regdto" + regdto);
			session.setAttribute("regular_end", "진행중");
			forward.setRedirect(true); // 성공 //Redirect방식
			forward.setPath("supportDone.jsp");
		} else {
			forward.setRedirect(true); // 실패 //Redirect방식
			forward.setPath("support.sp");
		}

		return forward;
	}
}
