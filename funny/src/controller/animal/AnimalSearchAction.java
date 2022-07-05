package controller.animal;

import controller.Action;
import controller.ActionForward;
import model.animal.AnimalDAO;
import model.animal.AnimalDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AnimalSearchAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalDAO anidao = new AnimalDAO();
		AnimalDTO animal = new AnimalDTO();
		request.setAttribute("seach", "seach");
		request.setAttribute("animal_species", request.getParameter("animal_species"));
		request.setAttribute("animal_gender", request.getParameter("animal_gender"));
		request.setAttribute("animal_weight", request.getParameter("animal_weight"));
		request.setAttribute("animal_age", request.getParameter("animal_age"));
		request.setAttribute("animal_name", request.getParameter("animal_name"));

		String animal_species="";
		if(request.getParameter("animal_species").equals("dog")) {
			animal_species = "개";
		} else if(request.getParameter("animal_species").equals("cat")) {
			animal_species = "고양이";
		}
		
		String animal_gender="";
		if(request.getParameter("animal_gender").equals("female")) {
			animal_gender = "암컷";
		} else if(request.getParameter("animal_gender").equals("male")) {
			animal_gender = "수컷";
		}
		
		int animal_weight_over = Integer.parseInt(request.getParameter("animal_weight").substring(0, 2)); //숫자 4자리, 앞2자리는 이상, 뒷2자리는 미만
		int animal_weight_under = Integer.parseInt(request.getParameter("animal_weight").substring(2, 4)); 
		double animal_age_more = Double.parseDouble(request.getParameter("animal_age").substring(0, 5)); // 숫자 10자리, 앞5자리는 이상, 뒷5자리는 이하
		double animal_age_less = Double.parseDouble(request.getParameter("animal_age").substring(5, 10)); 
		
		String animal_name = request.getParameter("animal_name");
		System.out.println(animal_name);

		animal.setAnimal_name(animal_name);
		animal.setAnimal_species(animal_species);
		animal.setAnimal_gender(animal_gender);
		animal.setAnimal_weight_over(animal_weight_over);
		animal.setAnimal_weight_under(animal_weight_under);
		animal.setAnimal_age_more(animal_age_more);
		animal.setAnimal_age_less(animal_age_less);
		
		// 전체 게시글 개수
		int totalCnt = anidao.selectSearchCnt(animal);

		// 페이징 처리
		// 현재 넘겨받은 페이지
		String temp = request.getParameter("page");
		int page = 0;

		page = temp == null ? 1 : Integer.parseInt(temp);

		// 페이지 처리 [1][2]...[10] : 10개씩
		int pageSize = 10;

		// 1페이지 endRow = 12, 4 페이지 endRow = 48
		int endRow = page * 12;
		// 1페이지 startRow = 1, 4 페이지 startRow = 37
		int startRow = endRow - 11;

		// [1][2]...[10] : [1], [11][12]..[20] : [11]
		int startPage = (page - 1) / pageSize * pageSize + 1;

		// [1][2]...[10] : [10], [11][12]..[20] : [20]
		int endPage = startPage + pageSize - 1;
		int totalPage = (totalCnt - 1) / (endRow - startRow + 1) + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		List<AnimalDTO> animalList = anidao.selectSearch(animal, startRow, endRow);
		request.setAttribute("animalList", animalList);
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("animalList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward
		
		return forward;
	}

}

