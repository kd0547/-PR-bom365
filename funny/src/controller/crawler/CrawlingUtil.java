package controller.crawler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PublicKey;

public class CrawlingUtil {
	
	
	

	private String encodingType = "UTF-8";
	

	
	
	
	/*
	 * 	�럹�씠吏� 踰덊샇�� String(媛�, 怨좎뼇�씠) �뜲�씠�꽣瑜� 諛쏆븘�꽌 URL�쓣 留뚮뱶�뒗 �븿�닔
	 * 	
	 * 	@param pageNum , animal
	 * 	@return URL
	 */
	public String getURL(int pageCount, String animal) {
		
		
		return "https://www.ekara.org/kams/adopt?page="+pageCount+"&activity=&species="+encodingString(animal)+"&sex=&name=&weight=&birth=";
	}
	
	/*
	 * 	�뙆�씪誘명꽣 媛믪쓣 �씤肄붾뵫�븳�떎. 
	 * 	�씤肄붾뵫 ���엯�� �궗�슜�옄媛� 誘몃━ 寃곗젙�븷 �닔 �엳�떎.
	 * 
	 * 	@param encodingSource  
	 * 	@return encodeResult - �씤肄붾뵫 �꽦怨� / null - �씤肄붾뵫 �떎�뙣
	 */
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
	
	
	
	
	
	
	/*
	 * 
	 * 	�씤肄붾뵫 ���엯�쓣 �뀑�똿�븳�떎.
	 * 	@param encodingType (�뵒�뤃�듃 : UTF-8);
	 * 	@return null
	 */
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}
	
	
	
}
