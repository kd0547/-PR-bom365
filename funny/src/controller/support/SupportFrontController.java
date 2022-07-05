package controller.support;

import controller.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SupportFrontController", value = "/SupportFrontController")
public class SupportFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response);
	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = null;

		// 요청을 파악
		String uri = request.getRequestURI();
		String cp = request.getContextPath();

		// 문자열 조작을 통하여 .do 파일에 대한 분석 (ex: main.do -> command = main)
		String command = uri.substring(cp.length() + 1, uri.length() - 3);
		System.out.println(command);

		// 정기후원신청
		if (command.equals("supportREGInsert")) {
			try {
				System.out.println("supportREGInsert.sp 경로 ok");
				forward = new SupportREGInsertAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportREGInsert.sp수행중 문제 발생");
			}
		}

		// 일시후원신청
		else if (command.equals("supportTEMInsert")) {
			try {
				System.out.println("supportTEMInsert.sp 경로 ok");
				forward = new SupportTEMInsertAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportTEMInsert.sp 수행중 문제 발생");
			}
		}

		// 정기후원종료신청
		else if (command.equals("supportREGEnd")) {
			try {
				System.out.println("supportREGEnd 경로 ok");
				forward = new SupportREGEndAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportREGEnd.sp 수행중 문제 발생");
			}
		}

		// 관리자 페이지 용 /////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 관리자 정기후원내역조회
		else if (command.equals("adminSupportREGList")) {
			try {
				System.out.println("adminSupportREGList.sp 경로 ok");
				forward = new AdminSupportREGListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("adminSupportREGList.sp 수행중 문제 발생");
			}
		}

		// 관리자 일시후원내역조회
		else if (command.equals("adminSupportTEMList")) {
			try {
				System.out.println("adminSupportTEMList.sp 경로 ok");
				forward = new AdminSupportTEMListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("adminSupportTEMList.sp 수행중 문제 발생");
			}
		}

		// 정기후원 정렬기능 REG
		else if (command.equals("adminREGCategory")) {
			try {
				System.out.println("adminREGCategory.sp 경로ok");
				forward = new AdminSupportREGCategoryAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("adminREGCategory.sp 수행중 문제 발생");
			}
		}

		// 정기후원 정렬기능 TEM
		else if (command.equals("adminTEMCategory")) {
			try {
				System.out.println("adminTEMCategory.sp 경로ok");
				forward = new AdminSupportTEMCategoryAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("adminTEMCategory.sp 수행중 문제 발생");
			}
		}

		// 만약 forward 가 null 이라면 null pointer exception 이 발생하기 떄문에 대비
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
