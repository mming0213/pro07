package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/prod")
public class ProductServlet extends HttpServlet {
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
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		
		//�� ���̵�
		//System.out.println("��ǰ ��ȣ: " + id);

		if(command != null && command.equals("delMember"))
		{
			
			String delid = request.getParameter("id");
			System.out.println("��ǰ��ȣȮ��" + delid);
			dao.delMember(delid);
			
		}
		else if(command != null && command.equals("addMember"))
		{
			System.out.println("��ǰ �߰� �Ǵ���");
			String _id = request.getParameter("id");
			String _name = request.getParameter("name");
			String _price = request.getParameter("price");
			String _prod_desc = request.getParameter("desc");
			String _vend_id = request.getParameter("vend");

			MemberVO vo = new MemberVO();
			
			vo.setProd_id(_id);
			vo.setProd_name(_name);
			vo.setProd_price(_price);
			vo.setProd_desc(_prod_desc);
			vo.setVend_id(_vend_id);
			
			dao.addMember(vo);
//			id = null;
//			vid = null;
		}
		String id = request.getParameter("prod_id");
		String vid = request.getParameter("vend_id");
	
		System.out.println("���̵�" + id +", ���Ƶ�"+vid);
		List list = dao.listMembers(id, vid);
		pw.print("<html><body>");
		pw.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		//pw.print("<td>����ȣ</td><td>����</td><td>�ֹ���ȣ</td><td>�ֹ���ǰ��ȣ</td><td>�ֹ���ǰ��</td><td>�ֹ���ȸ</td><td>����</td></tr>");
		pw.print("<td>��ǰ��ȣ</td><td>��ǰ��</td><td>��ǰ����</td><td>��ǰ����</td><td>���޾�ü��</td><td>����</td></tr>");
		
		for(int i = 0; i <list.size(); i++) {
			
			MemberVO memberVO = (MemberVO)list.get(i);
			String prod_id = memberVO.getProd_id();
			String prod_name = memberVO.getProd_name();
			double prod_price = Double.parseDouble(memberVO.getProd_price());
			String prod_desc = memberVO.getProd_desc();
			String vend_id = memberVO.getVend_id();
			String vend_name = memberVO.getVend_name();
			
			System.out.println(id + vid);
			//pw.print("<tr align=center bgcolor='#FFFF00'><td>" + cust_id + "</td><td>" + cust_name +"</td><td>" + order_num + "</td><td>" + prod_id + "</td><td>" + prod_name + "</td><td>" +"<a href='/pro07/member4?command=SearchMember&id="+id+"'>�ֹ���ȸ" + "</td><td>" + "<a href='/pro07/member4?command=SearchMember&id="+id+"'>����</a></td><tr>" );
			pw.print("<tr><td>" + prod_id + "</td><td>" + prod_name +"</td><td>" + prod_price + "</td><td>" + prod_desc +"</td><td>" + vend_name +"</td><td>"+ "<a href='/pro07/prod?command=delMember&id="+prod_id+"&vend_id="+vid+"&prod_id=" + id+"'>����</a></td><tr>" ); //"&custid=" + prod_id +
		}
		
		pw.print("<br><a href='/pro07/productinfo.html'>'�� ��ȣ �Է�â'</a><br>");
	}
}
