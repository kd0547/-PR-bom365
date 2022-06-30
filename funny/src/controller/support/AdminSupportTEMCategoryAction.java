package controller.support;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.ActionForward;
import model.support.SupportTEMDAO;
import model.support.SupportTEMDTO;

public class AdminSupportTEMCategoryAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자페이지 일시후원 카테고리 Action

		// 기본세팅
		ActionForward forward = new ActionForward();
		SupportTEMDAO temdao = new SupportTEMDAO();

		String category = request.getParameter("category");
		System.out.println("category 들어온값: " + category);

		// 페이지네이션 기본값
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
		if (category.equals("TEMAmountUp")) {

			// 전체 게시글 개수
			int totalCnt = temdao.AdminTEMCntOne();
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "TEMAmountUp";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportTEMDTO> AdminTEMList = temdao.AdminTEMAmountUpSelectList(startRow, endRow); // 오름차순전체 데이터 값 가져오기

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportTEMDTO v : AdminTEMList) {
				v.setTemporary_amount(df.format(Integer.parseInt(v.getTemporary_amount())));
			}

			request.setAttribute("AdminsupportTEMList", AdminTEMList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportTEMList.jsp");

			return forward;

		}

		////////////////////////////////////// 금액으로
		////////////////////////////////////// 검색////////////////////////////////////////
		// 내림차순
		if (category.equals("TEMAmountDown")) {

			// 전체 게시글 개수
			int totalCnt = temdao.AdminTEMCntOne();
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// 2페이지 이상 대비
			String prev = "TEMAmountDown";
			request.setAttribute("prev", prev);

			// 금액데이터 정리해서 파라미터 전달
			List<SupportTEMDTO> AdminTEMList = temdao.AdminTEMAmountDownSelectList(startRow, endRow); // 오름차순전체 데이터 값
																										// 가져오기

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportTEMDTO v : AdminTEMList) {
				v.setTemporary_amount(df.format(Integer.parseInt(v.getTemporary_amount())));
			}

			// 페이지네이션 적용일 경우 session에서 id get, 아니면 session에 저장
			request.setAttribute("AdminsupportTEMList", temdao.AdminTEMAmountDownSelectList(startRow, endRow));
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportTEMList.jsp");

			return forward;

		}

		/////////////////////////////////////// 아이디검색////////////////////////////////////////

		else if (category.equals("TEMSearch")) {

			// prev의 변수값으로 2페이지 이상일 때 해당 카테고리로 찾아옴
			String prev = "TEMSearch";
			request.setAttribute("prev", prev);

			// 세션에서 값 가져오기
			HttpSession session = request.getSession();

			String search_id = request.getParameter("search_id");
			session.setAttribute("search_id", search_id);

			// 페이지네이션에 따른 END페이지결정
			int totalCnt = temdao.AdminTEMSearchCntOne(search_id);
			System.out.println("totalCnt: " + totalCnt);
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			// 금액데이터 정리해서 파라미터 전달
			List<SupportTEMDTO> AdminTEMList = temdao.AdminTEMSearchSelectAll(startRow, endRow, search_id); // '진행중'데이터값전송

			DecimalFormat df = new DecimalFormat("###,###,###");
			for (SupportTEMDTO v : AdminTEMList) {
				v.setTemporary_amount(df.format(Integer.parseInt(v.getTemporary_amount())));
			}

			request.setAttribute("AdminsupportTEMList", AdminTEMList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("endPage", endPage);

			forward.setRedirect(false);// forward방식
			forward.setPath("/adminSupportTEMList.jsp");

			return forward;
		}

		return forward;
	}
}
