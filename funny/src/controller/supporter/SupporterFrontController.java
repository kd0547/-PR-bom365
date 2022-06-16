package controller.supporter;

import controller.ActionForward;
import controller.MainAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SupporterFrontController", value = "/SupporterFrontController")
public class SupporterFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		actionDO(request, response);
	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = null;
		
		// 요청을 파악
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		
		// 문자열 조작을 통하여 .do 파일에 대한 분석 (ex: main.do -> command = main)
		String command = uri.substring(cp.length() + 1, uri.length() - 3);
		System.out.println(command);
		// 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
		if (command.equals("main")) {
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("main.do 수행중 문제 발생");
			}
		}

		else if (command.equals("login")) {
			try {
				forward = new LogInAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("login.me 수행중 문제 발생");
			}
		}

		else if (command.equals("logout")) {
			try {
				forward = new LogOutAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("logout.me 수행중 문제 발생");
			}
		}
		
		else if(command.equals("idCheck")) {
			try {
				forward = new IDCheckAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("idCheck.me 수행중 문제 발생");
			}
		}
		
		else if(command.equals("signup")) {
			try {
				forward = new SignUpAction().execute(request, response);
				
			} catch (Exception e) {
				System.out.println("signup.me 수행중 문제 발생");
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