package controller.crawler;

import java.util.List;
import org.jsoup.nodes.Document;
import model.animal.AnimalVO;


public class Test {

	public static void main(String[] args) {
		InitDataCrawler crawling = new InitDataCrawler();
		crawling.getConnection(crawling.getURL(2, "개"));
		Document doc =  crawling.getHtmlData() ;
		
		List<AnimalVO> list = crawling.start(doc);
		
		for(int i=0; i < list.size();i++) {
			AnimalVO animal = list.get(i);
			System.out.println(animal.toString());
		}
		
		
	}

}
