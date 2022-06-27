package controller.support;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;

import model.supportRequest.SupportTEMRequestDAO;
import model.supportRequest.SupportTEMRequestDTO;
 
public class SupportTEMRequestAction implements Action{
	
	 @Override
	   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		    SupportTEMRequestDAO temdao = new SupportTEMRequestDAO();
		    SupportTEMRequestDTO temdto = new SupportTEMRequestDTO();
		    ActionForward forward = new ActionForward(); 
		    
		    //세션에서 ID값 꺼내오기
			 HttpSession session = req.getSession();
			 String supporter_id = (String)session.getAttribute("supporter_id");
			
			//후원날짜넣기
			 String pattern = "yyyy년 MM월 dd일";
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			 String temporary_date = simpleDateFormat.format(new Date());
			 
			//값넣기 
			temdto.setSupporter_id(supporter_id);
			temdto.setTemporary_amount(Integer.parseInt(req.getParameter("temporary_amount")));
			temdto.setTemporary_date(temporary_date);

			
			 if(temdao.supportTEMRequest(temdto)) {        
		            forward.setRedirect(true);
		            forward.setPath(req.getContextPath() + "/supportDone.jsp");
		        } else {                
		            forward.setRedirect(true);
		            forward.setPath(req.getContextPath() + "/index.jsp" );
		        }


		return forward;
	 }
}
