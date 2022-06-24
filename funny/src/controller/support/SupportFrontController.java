package controller.support;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import controller.MainAction;
import controller.board.BoardListAction;

@WebServlet("*.sp")
public class SupportFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
	        System.out.println("frontcontroller java파일 진입성공");
	        
	        if( requestURI.equals("/supportREGRequest.sp") ) {
	        	try {
	        		System.out.println("frontcontroller if문 진입성공:경로ok");
	        		forward = new SupportREGRequestAction().execute(req, resp);
	            }catch (Exception e) {
					System.out.println("REG.sp 수행중 문제 발생");
				}
	        }
	        

	        if( requestURI.equals("/supportTEMRequest.sp") ) {
	        	System.out.println("frontcontroller if문 진입성공:경로ok");
		        try {
		        	forward = new SupportTEMRequestAction().execute(req, resp);
		        }catch (Exception e) {
					System.out.println("TEM.sp 수행중 문제 발생");
					}
	        	}
	      
	/*	switch (requestURI) {

				case "/supprotREMRequest.sp": 
					 forward = new SupportREMRequestAction().execute(req, resp);
					break;
					
				case "/supprotTEMRequest.sp":
					forward = new SupportTEMRequestAction().execute(req, resp);
					break;
					
				default: System.out.println("SupportFrontController에서 문제 발생! 경로확인 필요");
		
			}*/
		



		// 일괄처리
		if (forward != null) {
			if (forward.isRedirect()) { // redirect
				resp.sendRedirect(forward.getPath());
			} else { // forward
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}

}
