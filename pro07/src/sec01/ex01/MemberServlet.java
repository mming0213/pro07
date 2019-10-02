//package sec01.ex01;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class MemberServlet
// */
//@WebServlet("/member")
//public class MemberServlet extends HttpServlet {
//	//private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		//out.print("<html><body>");
//		//out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
//		//out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
//		
//		
////		for(int i = 0; i <list.size(); i++) {
////			MemberVO memberVO = (MemberVO)list.get(i);
////			String id = memberVO.getId();
////			String pwd = memberVO.getPwd();
////			String name = memberVO.getName();
////			String email = memberVO.getEmail();
////			Date joinDate = memberVO.getJoinDate();
////		
////			out.print("<tr align=center bgcolor='#FFFF00'><td>" + id + "</td><td>" + pwd +"</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><tr>" );
////
////		}
//		
//		//out.print("</body></html>");
//		//out.print("</table></body></html>");
//		doHandle(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//doGet(request, response);
//		doHandle(request, response);
//	}
//	
//	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter pw = response.getWriter();
//		MemberDAO dao = new MemberDAO();
//		String command = request.getParameter("command");
//		
//		//고객 아이디
//		String id = request.getParameter("id");
//		System.out.println("고객 아이디: " + id);
//		String custid2 = request.getParameter("custid");
//		
//		
//		
//		
//		if(command != null && command.equals("delMember"))
//		{
//			//String id = request.getParameter("id");
//			//list = dao.listOrders(id);
//			dao.delMember(id);
//			
//		}
//		List list = dao.listMembers(custid2);
//		pw.print("<html><body>");
//		pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
//		//pw.print("<td>고객번호</td><td>고객명</td><td>주문번호</td><td>주문상품번호</td><td>주문상품명</td><td>주문조회</td><td>삭제</td></tr>");
//		pw.print("<td>고객번호</td><td>고객이름</td><td>고객주소</td><td>주문조회</td><td>삭제</td></tr>");
//		
//		for(int i = 0; i <list.size(); i++) {
//			
//			MemberVO memberVO = (MemberVO)list.get(i);
//			String cust_id = memberVO.getCust_id();
//			String cust_name = memberVO.getCust_name();
//			String cust_address = memberVO.getCust_address();
//			//String order_num = memberVO.getOrder_num();
//			//String prod_id = memberVO.getProd_id();
//			//String prod_name = memberVO.getProd_name();
//			
//			//pw.print("<tr align=center bgcolor='#FFFF00'><td>" + cust_id + "</td><td>" + cust_name +"</td><td>" + order_num + "</td><td>" + prod_id + "</td><td>" + prod_name + "</td><td>" +"<a href='/pro07/member4?command=SearchMember&id="+id+"'>주문조회" + "</td><td>" + "<a href='/pro07/member4?command=SearchMember&id="+id+"'>삭제</a></td><tr>" );
//			pw.print("<tr align=center bgcolor='#FFFF00'><td>" + cust_id + "</td><td>" + cust_name +"</td><td>" + cust_address + "</td><td>" + "<a href='/pro07/member4?command=SearchMember&id="+id+"'>주문조회" + "</td><td>" + "<a href='/pro07/member?command=delMember&id="+id+"&custid=" + cust_id +"'>삭제</a></td><tr>" );
//		}
//		
//		pw.print("<br><a href='/pro07/printinfo.html'>'고객 번호 입력창'</a><br>");
//	}
//
//}
