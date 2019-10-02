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
//
///**
// * Servlet implementation class MemberServlet4
// */
//@WebServlet("/member4")
//public class MemberServlet4 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
//	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		MemberDAO dao = new MemberDAO();
//		PrintWriter out = response.getWriter();
//		String command = request.getParameter("command");
//		
//		//회원 가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옵니다.
////		if(command != null && command.equals("addMember"))
////		{
////			String _id = request.getParameter("id");
////			String _pwd = request.getParameter("pwd");
////			String _name = request.getParameter("name");
////			String _email = request.getParameter("email");
////			MemberVO vo = new MemberVO();
////			vo.setId(_id);
////			vo.setPwd(_pwd);							  //회원 가입창에서 전송된 값들을 얻어와 MemberVO객체에 저장한 후 
////			vo.setName(_name);							  //SQL문을 이용해 전달합니다.
////			vo.setEmail(_email);
////			dao.addMember(vo);
////		}
//		//command 값이 delMember인 경우 ID를 가져와 SQL문으로 전달해서 삭제합니다.
////		if(command != null && command.equals("delMember"))
////		{
////			String id = request.getParameter("id");
////			dao.delMember(id);
////		}
//		
//		//다시 조회해줌.
////		if(command != null && command.equals("SearchMember"))
////		{
////			
////			//out.print("<a href = '/pro07/memberForm.html'>새 회원 가입하기</a>");
////		}
//		if(command != null && command.equals("delOrder"))
//		{
//			
//			String id = request.getParameter("id");
//			String order_num = request.getParameter("order_num");
//			String prod_id = request.getParameter("prod_id");
//			List list = dao.listOrders(id);
//			dao.delOrder(order_num, prod_id);
//			//System.out.println(order_num+name);
//			
////			out.print("<html><body>");
////			out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
////			out.print("<td>주문번호</td><td>제품명</td><td>항목수량</td><td>항목가격</td><td>삭제</td></tr>");
////			
////			for(int i = 0; i <list.size(); i++) {
////				MemberVO memberVO = (MemberVO)list.get(i);
////				String order_num = memberVO.getOrder_num();
////				String prod_name = memberVO.getProd_name();
////				String quantity = memberVO.getQuantity();
////				String item_price = memberVO.getItem_price();
////				
////			
////				//삭제를 클릭하면 command 값과 회원 ID를 서블릿으로 전송합니다.
////				out.print("<tr><td>" + order_num + "</td><td>" + prod_name +"</td><td>" + quantity + "</td><td>" + item_price + "</td><td>" + "<a href='/pro07/member4?command=delOrder&id="+order_num + "&name=" + prod_name + "'>삭제</a></td></tr>");
////			}
////			out.print("</table></body></html>");
//		}
//		
//		
//		String id = request.getParameter("id");
//		List list = dao.listOrders(id);
//		out.print("<html><body>");
//		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
//		out.print("<td>주문번호</td><td>제품명</td><td>항목수량</td><td>항목가격</td><td>삭제</td></tr>");
//	
//		for(int i = 0; i <list.size(); i++) {
//			MemberVO memberVO = (MemberVO)list.get(i);
//			String order_num = memberVO.getOrder_num();
//			String prod_name = memberVO.getProd_name();
//			String quantity = memberVO.getQuantity();
//			String item_price = memberVO.getItem_price();
//			String prod_id = memberVO.getProd_id();
//		
//			//삭제를 클릭하면 command 값과 회원 ID를 서블릿으로 전송합니다.
//			out.print("<tr><td>" + order_num + "</td><td>" + prod_name +"</td><td>" + quantity + "</td><td>" + item_price + "</td><td>" + "<a href='/pro07/member4?command=delOrder&order_num="+order_num + "&prod_id=" + prod_id + "&id=" + id  + "'>삭제</a></td></tr>");
//			
//		}
//		out.print("</table></body></html>");
//		
//		//List list = dao.listOrders(cust_id);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
//}
