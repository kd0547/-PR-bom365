package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import controller.volunteer.component.VolunteerCal;
import model.volunteer.VolunteerCnt;
import model.volunteer.VolunteerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class VolunteerListAction implements Action {

	// 요청한 연/월의 달력 출력
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; 	// 0~11

		if (request.getParameter("year") != null) {
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));
		}

		VolunteerCal volCal = new VolunteerCal(year, month);
		System.out.println("현재 달력 : " + volCal.getYear() + " / " + volCal.getMonth());
		System.out.println("오늘날짜 : " + volCal.getCurrentYear() + " / " + (volCal.getCurrentMonth()+1) + " / " + volCal.getCurrentDate());
		request.setAttribute("volCal", volCal);
		
		VolunteerDAO dao = new VolunteerDAO();
		ArrayList<VolunteerCnt> volCnts = dao.select(volCal);
		request.setAttribute("volCnts", volCnts);

		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("volunteerList.jsp");
		forward.setRedirect(false); // 넘겨줄 데이터가 있기 때문에 forward

		return forward;
	}
}
