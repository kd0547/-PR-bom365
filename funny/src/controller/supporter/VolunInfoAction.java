package controller.supporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import controller.Action;
import controller.ActionForward;
import model.supporter.SupporterDTO;
import model.volunteer.VolunteerDAO;
import model.volunteer.VolunteerDTO;


public class VolunInfoAction implements Action{
	
	VolunteerDAO regdao = new VolunteerDAO();
	VolunteerDTO regdto = new VolunteerDTO();
	SupporterDTO dto = new SupporterDTO();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supporter_id = request.getParameter("supporter_id");
		dto.setSupporter_id(supporter_id);
		List<VolunteerDTO> list = regdao.mypage(dto);
		JSONArray result = new JSONArray();
		int index = list.size();
		
		
		if(list.size() != 0) {
			int count =0;
			while( count < index ) {
				result.add(list.get(count));
				count++;
			}
		}

		System.out.println(result.toJSONString());
		
		response.getWriter().print(result.toJSONString());
		
		
		return null;
	}

}
