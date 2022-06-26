package controller.supporter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDAO;
import model.supporter.SupporterDTO;


public class UpdateAction implements Action{
	
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		SupporterDAO supporterDAO = new SupporterDAO();
		SupporterDTO supporterDTO;
		
		
		
		
		System.out.println(supporterDTO = createSupporterVO(request));
		supporterDTO.toString();
		
		if(supporterDAO.update(supporterDTO)) {
			forward = new ActionForward();
			
			forward.setPath("mypage.me");
			forward.setRedirect(false);
		} else {
			// 에러 페이지 
			forward = null;
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스크립트 printwriter
		// forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
		out.println("<script>alert('변경 완료');history.go(-1);</script>"); 
		
		return null;
	}
	
	public SupporterDTO createSupporterVO(HttpServletRequest request) throws IOException{
		SupporterDTO supporter = null;
		supporter = new SupporterDTO();
		//form에서 데이터가 
	
		
		supporter.setSupporter_id(request.getParameter("supporter_id"));
		supporter.setSupporter_name(request.getParameter("supporter_name"));
		supporter.setSupporter_password(request.getParameter("supporter_password"));
		supporter.setPhone_number(request.getParameter("phone_number"));
		supporter.setPost_code(request.getParameter("post_code"));
		supporter.setDetailed_address(request.getParameter("detailed_address"));
		
		
		
		return supporter;
	}

}
