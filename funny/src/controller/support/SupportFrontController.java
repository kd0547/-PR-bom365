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

	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = null;
		
		// 요청을 파악
		String uri = request.getRequestURI();
		String cp = request.getContextPath();

		// 문자열 조작을 통하여 .do 파일에 대한 분석 (ex: main.do -> command = main)
		String command = uri.substring(cp.length() + 1, uri.length() - 3);
		System.out.println(command);
		
		// 정기후원 진행 확인
		if (command.equals("support")) {
			try {
				System.out.println("support.sp 경로 ok");
				forward = new SupportMainAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("support.sp수행중 문제 발생");
			}
		}

		// 정기후원신청
		else if (command.equals("supportREGInsert")) {
			try {
				System.out.println("supportREGRequest.sp 경로 ok");
				forward = new SupportREGRequestAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportREGInsert.sp수행중 문제 발생");
				e.printStackTrace();
			}
		}

		// 일시후원신청
		else if (command.equals("supportTEMRequest")) {
			try {
				System.out.println("supportTEMRequest.sp 경로 ok");
				forward = new SupportTEMRequestAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportTEMRequest.sp 수행중 문제 발생");
			}
		}
		
		// 후원내역조회
		else if (command.equals("supportMypage")) {
			try {
				System.out.println("supportMypage.sp 경로 ok");
				forward = new MytableAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("supportMypage.sp 수행중 문제 발생");
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
