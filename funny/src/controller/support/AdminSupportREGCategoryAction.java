package controller.support;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.ActionForward;
import model.support.SupportREGDAO;
import model.support.SupportREGDTO;

public class AdminSupportREGCategoryAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자 후원내역 정렬기능

		// 기본세팅
		String category = request.getParameter("category");
		System.out.println("category:" + category);

		ActionForward forward = new ActionForward();
		SupportREGDAO regdao = new SupportREGDAO();

		// 페이지네이션 공통로직
		String temp = request.getParameter("page");
		int page = 0;

		page = temp == null ? 1 : Integer.parseInt(temp);

		int pageSize = 7;
		int endRow = page * 7;
		int startRow = endRow - 6;
		int startPage = (page - 1) / pageSize * pageSize + 1;
		int endPage = startPage + pageSize - 1;

		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);

		////////////////////////////////////// 금액으로
		////////////////////////////////////// 검색////////////////////////////////////////
		// 오름차순
		if (category.equals("REGAmountUp")) {

			// 페이지네이션 endpage 결정
			int totalCnt = regdao.AdminREGCntOne(); // 오름차순 전체데이터 수 값 가져오기
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "REGAmountUp";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportREGDTO> AdminREGList = regdao.AdminREGAmountUpSelectList(startRow, endRow); // 오름차순전체 데이터 값 가져오기

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportREGDTO v : AdminREGList) {
				v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			}

			request.setAttribute("AdminsupportREGList", AdminREGList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportREGList.jsp");

			return forward;

		}

		// 내림차순
		if (category.equals("REGAmountDown")) {

			// 페이지네이션 endpage 결정
			int totalCnt = regdao.AdminREGCntOne(); // 내림차순 전체페이지 수 값 가져오기
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "REGAmountDown";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportREGDTO> AdminREGList = regdao.AdminREGAmountDownSelectList(startRow, endRow); // 내림차순전체 데이터 값
																										// 가져오기

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportREGDTO v : AdminREGList) {
				v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			}

			request.setAttribute("AdminsupportREGList", AdminREGList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportREGList.jsp");

			return forward;

		}

		////////////////////////////////////// 상황별로
		////////////////////////////////////// 검색////////////////////////////////////////
		// 상황순(종료)
		else if (category.equals("REGsituationEnd")) {

			// 페이지네이션에 따른 endpage결정
			int totalCnt = regdao.TotalCountSituationEnd(); // 상황순(종료)전체 데이터값 가져오기
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "REGsituationEnd";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportREGDTO> AdminREGList = regdao.AdminREGEndtSelectAll(startRow, endRow); // '종료' 정렬 데이터 전송

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportREGDTO v : AdminREGList) {
				v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			}

			request.setAttribute("AdminsupportREGList", AdminREGList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportREGList.jsp");

		}

		// 상황순(진행중)
		else if (category.equals("REGsituationIng")) {

			// 페이지네이션애 따른 마지막 페이지 결정
			int totalCnt = regdao.TotalCountSituationIng(); // 상황별(진행중) 페이지네이션 전체 값 가져오기
			int totalPage = (totalCnt - 1) / (endRow - startRow + 1) + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "REGsituationIng";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportREGDTO> AdminREGList = regdao.AdminREGIngtSelectAll(startRow, endRow); // '진행중'데이터값전송

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportREGDTO v : AdminREGList) {
				v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			}

			request.setAttribute("AdminsupportREGList", AdminREGList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportREGList.jsp");

			return forward;
		}

		/////////////////////////////////////// 아이디검색////////////////////////////////////////

		else if (category.equals("REGSearch")) {

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "REGSearch";
			request.setAttribute("prev", prev);

			// 세션에서 값 가져오기
			HttpSession session = request.getSession();

			String search_id = request.getParameter("search_id");
			session.setAttribute("search_id", search_id);

			// 페이지네이션에 따른 END페이지결정
			int totalCnt = regdao.AdminREGSearchCntOne(search_id);
			System.out.println("totalCnt: " + totalCnt);
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// 금액데이터 정리해서 파라미터 전달
			List<SupportREGDTO> AdminREGList = regdao.AdminREGSearchSelectAll(startRow, endRow, search_id); // '진행중'데이터값전송

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportREGDTO v : AdminREGList) {
				v.setRegular_amount(df.format(Integer.parseInt(v.getRegular_amount())));
			}

			request.setAttribute("AdminsupportREGList", AdminREGList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportREGList.jsp");

			return forward;
		}

		return forward; // 최종적으로 forward 를 반환한다
	}
}
