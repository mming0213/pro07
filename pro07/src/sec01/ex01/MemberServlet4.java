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
//		//ȸ�� ����â���� ���۵� command�� addMember�̸� ���۵� ������ �޾ƿɴϴ�.
////		if(command != null && command.equals("addMember"))
////		{
////			String _id = request.getParameter("id");
////			String _pwd = request.getParameter("pwd");
////			String _name = request.getParameter("name");
////			String _email = request.getParameter("email");
////			MemberVO vo = new MemberVO();
////			vo.setId(_id);
////			vo.setPwd(_pwd);							  //ȸ�� ����â���� ���۵� ������ ���� MemberVO��ü�� ������ �� 
////			vo.setName(_name);							  //SQL���� �̿��� �����մϴ�.
////			vo.setEmail(_email);
////			dao.addMember(vo);
////		}
//		//command ���� delMember�� ��� ID�� ������ SQL������ �����ؼ� �����մϴ�.
////		if(command != null && command.equals("delMember"))
////		{
////			String id = request.getParameter("id");
////			dao.delMember(id);
////		}
//		
//		//�ٽ� ��ȸ����.
////		if(command != null && command.equals("SearchMember"))
////		{
////			
////			//out.print("<a href = '/pro07/memberForm.html'>�� ȸ�� �����ϱ�</a>");
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
////			out.print("<td>�ֹ���ȣ</td><td>��ǰ��</td><td>�׸����</td><td>�׸񰡰�</td><td>����</td></tr>");
////			
////			for(int i = 0; i <list.size(); i++) {
////				MemberVO memberVO = (MemberVO)list.get(i);
////				String order_num = memberVO.getOrder_num();
////				String prod_name = memberVO.getProd_name();
////				String quantity = memberVO.getQuantity();
////				String item_price = memberVO.getItem_price();
////				
////			
////				//������ Ŭ���ϸ� command ���� ȸ�� ID�� �������� �����մϴ�.
////				out.print("<tr><td>" + order_num + "</td><td>" + prod_name +"</td><td>" + quantity + "</td><td>" + item_price + "</td><td>" + "<a href='/pro07/member4?command=delOrder&id="+order_num + "&name=" + prod_name + "'>����</a></td></tr>");
////			}
////			out.print("</table></body></html>");
//		}
//		
//		
//		String id = request.getParameter("id");
//		List list = dao.listOrders(id);
//		out.print("<html><body>");
//		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
//		out.print("<td>�ֹ���ȣ</td><td>��ǰ��</td><td>�׸����</td><td>�׸񰡰�</td><td>����</td></tr>");
//	
//		for(int i = 0; i <list.size(); i++) {
//			MemberVO memberVO = (MemberVO)list.get(i);
//			String order_num = memberVO.getOrder_num();
//			String prod_name = memberVO.getProd_name();
//			String quantity = memberVO.getQuantity();
//			String item_price = memberVO.getItem_price();
//			String prod_id = memberVO.getProd_id();
//		
//			//������ Ŭ���ϸ� command ���� ȸ�� ID�� �������� �����մϴ�.
//			out.print("<tr><td>" + order_num + "</td><td>" + prod_name +"</td><td>" + quantity + "</td><td>" + item_price + "</td><td>" + "<a href='/pro07/member4?command=delOrder&order_num="+order_num + "&prod_id=" + prod_id + "&id=" + id  + "'>����</a></td></tr>");
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
