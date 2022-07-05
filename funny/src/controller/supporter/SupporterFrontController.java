package controller.supporter;

import controller.ActionForward;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		// 아이디 중복 체크
		if(command.equals("idCheck")) {
			try {
				forward = new IDCheckAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("idCheck.me 수행중 문제 발생");
			}
		}

		// 회원가입
		else if(command.equals("signup")) {
			try {
				forward = new SignUpAction().execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("signup.me 수행중 문제 발생");
			}
		}

		// 로그인
		else if (command.equals("login")) {
			try {
				forward = new LogInAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("login.me 수행중 문제 발생");
				e.printStackTrace();
			}
		}

		// 로그아웃
		else if (command.equals("logout")) {
			try {
				forward = new LogOutAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("logout.me 수행중 문제 발생");
			}
		}
		
		// 마이페이지 이동
		else if(command.equals("mypage")) {
			try {
				forward = new MyPageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("mypage.me 수행중 문제 발생");
			}
		}

		// 회원 정보 수정
		else if(command.equals("update")) {
			try {
				forward = new UpdateAction().execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("update.me 수행중 문제 발생");
			}
		}
		
		// 회원 탈퇴
		else if(command.equals("withdrawal")) {
			try {
				forward = new WithdrawalAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("withdrawal.me 수행중 문제 발생");
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