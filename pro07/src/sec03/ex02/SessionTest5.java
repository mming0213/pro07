package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest5
 */
@WebServlet("/login2")
public class SessionTest5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) {//최초 요청 시 수행
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				//변수 url에 encodeURL()를 이용해 응답 시 미리 jsessionId를 저장합니다.
				String url = response.encodeURL("login2");
				//로그인 상태 확인 클릭 시 jsessionId를 서블릿으로 다시 전송한다.
				out.println("<a href="+url+">로그인 상태 확인</a>");
			}
			else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
		else 
		{
			user_id = (String) session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0)
			{
				out.println("안녕하세요 " + user_id + "님!!!");
			}
			else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}
}
