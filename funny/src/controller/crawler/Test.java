package controller.crawler;

import java.util.List;
import org.jsoup.nodes.Document;

import model.animal.AnimalDAO;
import model.animal.AnimalVO;


public class Test {

	public static void main(String[] args) {
		InitDataCrawler crawling = new InitDataCrawler();
		
		//매개변수에 개 OR 고양이를 입력
		// 크롤링 페이지 설정
		crawling.getConnection(crawling.getURL(1, "고양이"));
		
		/*
		 * ex)
		 *  개를 3페이지 크롤링할 경우
		 *  

		for(int i =1;i<=3;i++) {
			crawling.getConnection(crawling.getURL(i, "개"));
		}
		*/
		
		Document doc =  crawling.getHtmlData() ;
		
		/*
		 * 크롤링한 데이터를 매개변수로 start()를 실행
		 * 
		 * @param josup > document 
		 * @return start는 List<>를 반환 
		 */
		List<AnimalVO> list = crawling.start(doc);
		
		
		for(int i=0; i < list.size();i++) {
			AnimalVO animal = list.get(i);
			System.out.println(animal);
		}
		
		AnimalDAO dao = new AnimalDAO();
		dao.insertAll(list);
		
		
	}

}