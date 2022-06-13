package controller.crawler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CrawlingUtil {
	
	
	

	private String encodingType = "UTF-8";
	

	
	public String getURL(int pageCount, String animal) {
		
		
		return "https://www.ekara.org/kams/adopt?page="+pageCount+"&activity=&species="+encodingString(animal)+"&sex=&name=&weight=&birth=";
	}
	
	public String encodingString(String encodingSource) {
		String encodeStringResult= null;
		
		try {
			encodeStringResult= URLEncoder.encode(encodingSource, encodingType);
			
			
			return encodeStringResult;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		return encodeStringResult;
	}
	
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}
	
	
	
}

