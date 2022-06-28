package controller.application;

import controller.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApplicationFrontController", value = "/ApplicationFrontController")
public class ApplicationFrontController extends HttpServlet {
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

		// 신청 페이지 이동
		if (command.equals("applicationRequest")) {
			try {
				forward = new ApplicationRequestAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("applicationRequest.ap 수행중 문제 발생");
			}
		}

		// 신청하기
		else if (command.equals("applicationInsert")) {
			try {
				forward = new ApplicationInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("applicationInsert.ap 수행중 문제 발생");
			}
		}

		// 관리자 페이지 용 ///////////////////////////////////////////////////////////////////////////////////////////////////////
		// 전체 신청서 목록
		else if (command.equals("adminApplicationList")) {
			try {
				forward = new AdminApplicationListAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("adminApplicationList.ap 수행중 문제 발생");
			}
		}

		// 상세글보기
		else if (command.equals("adminApplicationOne")) {
			try {
				forward = new AdminApplicationOneAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("adminApplicationOne.ap 수행중 문제 발생");
				e.printStackTrace();
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
