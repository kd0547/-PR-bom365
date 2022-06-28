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
import controller.component.Today;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;
import model.support.SupportTEMDAO;
import model.support.SupportTEMDTO;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;

public class MyPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(); // spring 식 session 을 받는법
		// 회원 정보 불러오기 //////////////////////////////////////////////////////////////////////////////
		SupporterDAO dao = new SupporterDAO();
		SupporterDTO dto = new SupporterDTO();

		// 세션에서 ID값 꺼내오기
		String id = (String) session.getAttribute("supporter_id");

		dto.setSupporter_id(id);

		dto = dao.SupporterIdInfo(dto);
		request.setAttribute("userInfo", dto);

		// 후원 내역 불러오기 //////////////////////////////////////////////////////////////////////////////
		SupportREGDAO regdao = new SupportREGDAO();
		SupportTEMDAO temdao = new SupportTEMDAO();

		// dao데이터 받아옴
		List<SupportREGDTO> mypageREGList = regdao.mypage(dto);
		List<SupportTEMDTO> mypageTEMList = temdao.mypage(dto);

		DecimalFormat df = new DecimalFormat("###,###,###");
		for (SupportREGDTO v : mypageREGList) {
			v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			v.setRegular_date(v.getRegular_date().substring(2, 7));
			v.setRegular_end(v.getRegular_end().substring(2));
		}
		for (SupportTEMDTO v : mypageTEMList) {
			v.setTemporary_amount(df.format(Integer.parseInt(v.getTemporary_amount())));
		}

		// 파라미터로 값 전달
		request.setAttribute("MypageREGList", mypageREGList);
		System.out.println("MypageRegList " + mypageREGList);
		request.setAttribute("MypageTEMList", mypageTEMList);
		System.out.println("MypageTEMList " + mypageTEMList);

		// 봉사 신청 내역 불러오기 //////////////////////////////////////////////////////////////////////////////
		
		VolunteerDAO voldao = new VolunteerDAO();
		
		List<VolunteerDTO> mypageVolList = voldao.mypage(dto);
		request.setAttribute("mypageVolList", mypageVolList);
		
		String today = new Today().today();
		request.setAttribute("today", today);
		

		// 문제 없으면 실행
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
