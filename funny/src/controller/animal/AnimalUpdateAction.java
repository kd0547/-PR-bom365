package controller.animal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.animal.AnimalDAO;
import model.application.ApplicationDAO;
import model.application.ApplicationDTO;

	//입양처리
	public class AnimalUpdateAction implements Action {

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			ActionForward forward = new ActionForward();
			AnimalDAO amdao = new AnimalDAO();
			ApplicationDAO apdao = new ApplicationDAO();
			ApplicationDTO apdto = new ApplicationDTO();
			
			String supporter_id = request.getParameter("supporter_id");
			int animal_number = Integer.parseInt(request.getParameter("animal_number"));
		    
			// 입양 채택하기
			if(amdao.update(supporter_id, animal_number)) {
				System.out.println("채택완료");
			}
		
			apdto.setApplication_number(Integer.parseInt(request.getParameter("application_number")));
			
			request.setAttribute("application", apdao.selectOne(apdto));
			forward.setRedirect(false);
			forward.setPath("adminApplicationOne.jsp");
			
			return forward;
	}

}

