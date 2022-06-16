package controller.board;

import controller.ActionForward;
import controller.MainAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BoardFrontController", value = "/BoardFrontController")
public class BoardFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println(command);
		// 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
		if (command.equals("main")) {
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("main.do 수행중 문제 발생");
			}
		}
		
		// 글목록
		else if (command.equals("boardList")) {
			try {
				forward = new BoardListAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardList.do 수행중 문제 발생");
			}
		}
		
		// 최신순, 좋아요순, 내글보기 버튼 클릭시 수행 액션
		else if (command.equals("boardCategory")) {
			try {
				forward = new BoardCategoryAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardCategory.do 수행중 문제 발생");
			}
		}
		
		// 검색하기 버튼 클릭시 수행 액션
		else if (command.equals("boardSearch")) {
			try {
				forward = new BoardSearchAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardSearch.do 수행중 문제 발생");
			}
		}
		
		// 상세글 보기
		else if (command.equals("boardDetail")) {
			try {
				forward = new BoardDetailAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDetail.do 수행중 문제 발생");
			}
		}
		
		//글 삭제하기
		else if (command.equals("boardDelete")) {
			try {
				forward = new BoardDeleteAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDelete.do 수행중 문제 발생");
			}
		} 
		
		//댓글 삭제하기
		else if (command.equals("commentDelete")) {
			try {
				forward = new CommentDeleteAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardDelete.do 수행중 문제 발생");
			}
		} 
		
		// 글 작성하기
		else if (command.equals("boardInsert")) {
			try {
				forward = new BoardInsertAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardInsert.do 수행중 문제 발생");
			}
		} 
		
		// 댓글 작성하기
		else if (command.equals("commentInsert")) {
			try {
				forward = new CommentInsertAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("commentInsert.do 수행중 문제 발생");
			}
		} 
		
		// 글 수정 페이지 이동
		else if (command.equals("boardUpdatePage")) {
			try {
				forward = new BoardUpdatePageAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardUpdatePage.do 수행중 문제 발생");
			}
		}
		
		// 글 수정하기
		else if (command.equals("boardUpdate")) {
			try {
				forward = new BoardUpdateAction().execute(request, response);
			} catch (Exception e) {
				System.out.println("boardUpdate.do 수행중 문제 발생");
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
