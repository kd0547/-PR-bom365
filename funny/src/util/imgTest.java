package util;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;




@WebServlet("/image.im")
public class imgTest extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("파일 입력");
	}
	
	
	public void uploadImg(HttpServletRequest req,HttpServletResponse resp, MultipartRequest upload) throws Exception {
		
		
	}
	
	
	
	
	
}
