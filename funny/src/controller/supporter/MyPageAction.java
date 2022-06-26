package controller.supporter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;
import model.support.SupportTEMDAO;
import model.support.SupportTEMDTO;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

public class MyPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(); // spring 식 session 을 받는법
		SupporterDAO dao = new SupporterDAO();
		SupporterDTO dto = new SupporterDTO();

		// 회원 정보 불러오기 //////////////////////////////////////////////////////////////////////////////
		// 세션에서 ID값 꺼내오기
		String id = (String) session.getAttribute("supporter_id");

		dto.setSupporter_id(id);

		dto = dao.SupporterIdInfo(dto);
		request.setAttribute("userInfo", dto);

		// 후원 내역 불러오기 //////////////////////////////////////////////////////////////////////////////
		SupportREGDAO regdao = new SupportREGDAO();
		SupportTEMDAO temdao = new SupportTEMDAO();

		// dao데이터 받아옴
		List<SupportREGDTO> MypageREGList = regdao.MypageREG(id);
		List<SupportTEMDTO> MypageTEMList = temdao.MypageTEM(id);
		System.out.println("dao에서 값 받아옴");

		DecimalFormat df = new DecimalFormat("###,###,###");
		for (SupportREGDTO v : MypageREGList) {
			v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			v.setRegular_date(v.getRegular_date().substring(2));
			v.setRegular_end(v.getRegular_end());
		}
		for (SupportTEMDTO v : MypageTEMList) {
			v.setTemporary_amount(df.format(Integer.parseInt(v.getTemporary_amount())));
		}

		// 파라미터로 값 전달
		request.setAttribute("MypageREGList", MypageREGList);
		System.out.println("MypageRegList " + MypageREGList);
		request.setAttribute("MypageTEMList", MypageTEMList);
		System.out.println("MypageTEMList " + MypageTEMList);

		// 문제 없으면 실행
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
