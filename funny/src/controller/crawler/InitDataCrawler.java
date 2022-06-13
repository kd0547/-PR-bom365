package controller.crawler;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import model.animal.AnimalVO;


public class InitDataCrawler extends CrawlingUtil{
	private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";
	private  Connection connection;
	public Connection getConnection(String URL) {
		
		connection = Jsoup.connect(URL)
				.userAgent(USER_AGENT)
				.method(Connection.Method.GET)
				.ignoreContentType(true);
					
		return connection;
		
	}
	/*
	 * 
	 * 	Connection 객체에서 HTML 데이터를 가져온다
	 * 	 
	 */
	public Document  getHtmlData() {
		try {
			return connection.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 *  
	 * 	
	 * 
	 * 
	 */
	public List<AnimalVO> start(Document document) {
		
		Elements col_sm_6 =  document.getElementsByClass("col-sm-6");
		int size = col_sm_6.size();
		List<AnimalVO> list = new ArrayList<>();
		
		Element element=null;
		//Map<String[], String[]> animal = new HashMap<String[], String[]>();
		
		for(int i=0;i<col_sm_6.size();i++) {
			element =  col_sm_6.get(i);
			
			list.add(new AnimalVO(
					getName(element),
					getAnimalType(getSpecies(element)),
					getNameSpecies(getSpecies(element)),
					getGender(element),
					getAge(getAWC(element)),
					getWeight(getAWC(element)),
					getImgSrc(element),
					"false"
					));
			
			
		}
		return list;
		
		
		
	}
	public String getNameSpecies(String Species) {
		
		return Species.replaceAll("[고양이 | 개]+", "").replaceAll("[( | )]+","");
	}
	public String getAnimalType(String Species) {
		
		return Species.replaceAll("\\(+[가-힣 | \\s ]+\\)", "").trim();
	}

	
	public String  getAge(String AWC) {
		String[] weight;
		
		weight = AWC.split("/");
		
		
		return weight[0];
	}
	/*
	 * 몸무게 추출
	 * 
	 */
	public double  getWeight(String AWC) {
		String[] weight;
		
		weight = AWC.split("/");
		
		return  Double.parseDouble(weight[1].replace("kg","").trim());
	}
	
	
	/*
	 * 이미지 URL 추출
	 * Element 를 넘기면 이미지에 있는 URL을 추출한다
	 * 
	 */
	public String getImgSrc(Element Element) {
		String result = Element.getElementsByClass("card-img-top").attr("src");
		return "https://www.ekara.org/"+result;
		
	}
	/*
	 * 
	 * A태그 href 추출
	 */
	public String getAtag(Element Element) {
		
		return Element.getElementsByTag("a").attr("href").toString();
	}
	/*
	 *  개, 고양이 이름 추출
	 * 
	 */
	public String getName(Element Element) {
		
		return Element.getElementsByClass("h5 font-weight-bold").text().trim();
	}
	/*
	 * 종 추출
	 *
	 */
	public String getSpecies(Element Element) {
		Elements element = Element.getElementsByClass("text-secondary mb-0");
		List<TextNode> textList =  element.textNodes();
		
		return textList.get(0).toString().trim();
	}
	/*
	 * 성별 추출
	 * 
	 */
	public String getGender(Element Element) {
		Elements element = Element.getElementsByClass("text-secondary mb-0");
		List<TextNode> textList =  element.textNodes();
		
		return textList.get(1).toString().trim();
	}
	/*
	 * 특징 추출
	 */
	public String getAWC(Element Element) {
		Elements element = Element.getElementsByClass("text-secondary mb-0");
		List<TextNode> textList =  element.textNodes();
		
		return textList.get(2).toString().trim();
	}
	
	
}