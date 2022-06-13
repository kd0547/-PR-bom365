package controller.crawler;

import java.util.List;
import org.jsoup.nodes.Document;

import model.animal.AnimalDAO;
import model.animal.AnimalVO;


public class Test {

	public static void main(String[] args) {
		InitDataCrawler crawling = new InitDataCrawler();
		AnimalDAO dao = new AnimalDAO();
		/*
		 * 
		 * 
		 * 
		 */
		for(int i =1;i<=5;i++) {
			crawling.getConnection(crawling.getURL(i, "개"));
			Document doc =  crawling.getHtmlData() ;
			List<AnimalVO> list = crawling.start(doc);
			
			dao.insertAll(list);
		}
		

		for(int i =1;i<=5;i++) {
			crawling.getConnection(crawling.getURL(i, "고양이"));
			Document doc =  crawling.getHtmlData() ;
			List<AnimalVO> list = crawling.start(doc);
			
			dao.insertAll(list);
		}
		
		
		
		
	}

}

