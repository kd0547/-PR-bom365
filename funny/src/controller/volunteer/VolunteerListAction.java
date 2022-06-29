package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import controller.component.Today;
import controller.volunteer.component.VolunteerCal;
import model.supporter.SupporterDTO;
import model.volunteer.VolunteerCnt;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VolunteerListAction implements Action {

	// 요청한 연/월의 달력 출력
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		HttpSession session = request.getSession(); // spring 식 session 을 받는법
		String supporter_id = (String) session.getAttribute("supporter_id");

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0~11

		if (request.getParameter("year") != null) {
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));
		}

		VolunteerCal volCal = new VolunteerCal(year, month);
		System.out.println("현재 달력 : " + volCal.getYear() + " / " + volCal.getMonth());
		System.out.println("오늘날짜 : " + volCal.getCurrentYear() + " / " + volCal.getCurrentMonth() + " / "
				+ volCal.getCurrentDate());
		request.setAttribute("volCal", volCal);

		VolunteerDAO dao = new VolunteerDAO();
		ArrayList<VolunteerCnt> volCnts = dao.select(volCal);
		request.setAttribute("volCnts", volCnts);

		// Action 값 지정
		ActionForward forward = new ActionForward();

		if ("admin".equals(supporter_id)) {
			// 키워드 검색 불러오기 //////////////////////////////////////////////////////////////////////////////////
			String id = request.getParameter("keyword");
			if (id != null) {
				SupporterDTO dto = new SupporterDTO();
				dto.setSupporter_id(id);

				List<VolunteerDTO> searchList = dao.selectSupporter(dto);
				request.setAttribute("searchList", searchList);

				String today = new Today().today();
				request.setAttribute("today", today);
			}

			forward.setPath("adminVolunteerList.jsp");
		} else {
			forward.setPath("volunteerList.jsp");
		}
		forward.setRedirect(false); // 넘겨줄 데이터가 있기 때문에 forward

		return forward;
	}
}
