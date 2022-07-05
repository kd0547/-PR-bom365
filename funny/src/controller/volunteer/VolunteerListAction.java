package controller.volunteer;

import controller.Action;
import controller.ActionForward;
import controller.component.Today;
import controller.volunteer.component.VolunteerCal;
import model.supporter.SupporterDTO;
import model.volunteer.VolunteerCnt;
import model.volunteer.VolunteerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
			// 키워드 검색 불러오기 ////////////////////////////////////////////////////////////////////////////////////
			String search_id = request.getParameter("search_id"); // view 에서 검색 된 키워드
			request.setAttribute("search_id", search_id);
			if (search_id != null) {
				SupporterDTO dto = new SupporterDTO();
				dto.setSupporter_id(search_id);

				// 전체 검색 글 개수
				int totalCnt = dao.selectSearchCnt(dto);

				// 페이징 처리
				// 현재 넘겨받은 페이지
				String temp = request.getParameter("page");
				int page = 0;

				page = temp == null ? 1 : Integer.parseInt(temp);

				// 페이지 처리 [1][2]...[10] : 10개씩
				int pageSize = 10;

				// 1페이지 endRow = 10, 4 페이지 endRow = 40
				int endRow = page * 5;
				// 1페이지 startRow = 1, 4 페이지 startRow = 31
				int startRow = endRow - 4;

				// [1][2]...[10] : [1], [11][12]..[20] : [11]
				int startPage = (page - 1) / pageSize * pageSize + 1;
				// [1][2]...[10] : [10], [11][12]..[20] : [20]
				int endPage = startPage + pageSize - 1;
				int totalPage = (totalCnt - 1) / (endRow - startRow + 1) + 1;

				endPage = endPage > totalPage ? totalPage : endPage;

				request.setAttribute("totalPage", totalPage);
				request.setAttribute("nowPage", page);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);

				request.setAttribute("totalCnt", totalCnt);
				request.setAttribute("searchList", dao.selectSearch(dto, startRow, endRow));

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
