package controller.supporter;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		SupporterDAO dao = new SupporterDAO();
		SupporterDTO vo = new SupporterDTO();

		
		
		
		
		
		// 수정 후 상세게시물로 이동
		forward.setPath("mypage.me");
		forward.setRedirect(true); // 넘겨줄 데이터 X
		return forward;
	}
}
