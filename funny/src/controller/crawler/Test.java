package controller.crawler;

import java.util.List;
import org.jsoup.nodes.Document;

import model.animal.AnimalDAO;
import model.animal.AnimalDTO;


public class Test {

	public static void main(String[] args) {
		InitDataCrawler crawling = new InitDataCrawler();
		AnimalDAO dao = new AnimalDAO();
		/*
		 * 
		 * 
		 * 
		 */
		for(int i =1;i<=7;i++) {
			crawling.getConnection(crawling.getURL(i, "개"));
			Document doc =  crawling.getHtmlData() ;
			List<AnimalDTO> list = crawling.start(doc);
			
			if (dao.insertAll(list)) {
				System.out.println("개 : " + i + "페이지 초기데이터 설정 완료");
			}
		}
		

		for(int i =1;i<=7;i++) {
			crawling.getConnection(crawling.getURL(i, "고양이"));
			Document doc =  crawling.getHtmlData() ;
			List<AnimalDTO> list = crawling.start(doc);
			
			if (dao.insertAll(list)) {
				System.out.println("고양이 : " + i + "페이지 초기데이터 설정 완료");
			}
		}
		
		
		
		
	}

}

