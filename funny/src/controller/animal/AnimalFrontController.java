package controller.animal;

import controller.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnimalFrontController", value = "/AnimalFrontController")
public class AnimalFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		// 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
		
		// 동물 목록
		if (command.equals("animalList")) {
			try {
				forward = new AnimalListAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("animalList.am 수행중 문제 발생");
				e.printStackTrace();
			}
		}
		
		// 상세 페이지
		else if (command.equals("animalOne")) {
			try {
				forward = new AnimalOneAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("animalOne.am 수행중 문제 발생");
			}
		}
		
		// 동물 검색
		else if (command.equals("animalSearch")) {
			try {
				forward = new AnimalSearchAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("animalSearch.am 수행중 문제 발생");
				e.printStackTrace();
			}
		}

		// 관리자 페이지 용 ///////////////////////////////////////////////////////////////////////////////////////////////////////
		// 입양 채택
		else if (command.equals("animalUpdate")) {
			try {
				forward = new AnimalUpdateAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("animalUpdate.am 수행중 문제 발생");
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
