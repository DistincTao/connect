

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TodayServlet
 */
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html lang='ko'>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			out.println("<link rel=\"stylesheet\" href='css/today.css'></li>");
			out.println("<title>현재 시간</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<header class='header'>");
			out.println("    <ul class=\"navBar\">\n"
					+ "      <li id=\"home\" onclick=\"location.href='index.html'\">홈</li>\n"
					+ "      <li id=\"aboutMe\" onclick=\"location.href='aboutme.html'\">자기소개</li>\n"
					+ "      <li id=\"photo\"onclick=\"location.href='photo.html'\">내사진</li>\n"
					+ "      <li id=\"today\" onclick=\"location.href='http://localhost:8080/aboutme/today'\">현재시간은?</li>\n"
					+ "    </ul>");
			out.println("</header>");
			
			out.println("<section>");
			out.println("<p id='today'>현재시간은 : 10시 20분 30초 </p>");
			out.println("</section>");
			out.println("<footer>");
			out.println("<div>distinctao@gmail.com</div>");
			out.println("<div><a href='http://github.com/distinctao'>http://github.com/distinctao</a></div>");
	    	out.println("</footer>");
			out.println("<script> let today = new Date(); document.getElementById(\"today\").innerHTML = `오늘은 : ${today}`");
			out.println("</body></html>");
			
		} finally {
			out.close();
		}
				
	}

}