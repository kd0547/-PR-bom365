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

		AnimalDTO animal = new AnimalDTO();
		animal.setAnimal_name(animal_name);
		animal.setAnimal_species(animal_species);
		animal.setAnimal_gender(animal_gender);
		animal.setAnimal_weight_over(animal_weight_over);
		animal.setAnimal_weight_under(animal_weight_under);
		animal.setAnimal_age_more(animal_age_more);
		animal.setAnimal_age_less(animal_age_less);
		
		List<AnimalDTO> animalList = anidao.selectSearch(animal);
		request.setAttribute("animalList", animalList);
		// Action 값 지정
		ActionForward forward = new ActionForward();
		forward.setPath("animalList.jsp");
		forward.setRedirect(false); // dao로 부터 받은 리스트를 넘겨줘야하기 때문에 forward
		
		return forward;
	}

}

