package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet3
 */
@WebServlet("/member3")
public class MemberServlet3 extends HttpServlet {
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

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		//ȸ�� ����â���� ���۵� command�� addMember�̸� ���۵� ������ �޾ƿɴϴ�.
		if(command != null && command.equals("addMember"))
		{
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);							  //ȸ�� ����â���� ���۵� ������ ���� MemberVO��ü�� ������ �� 
			vo.setName(_name);							  //SQL���� �̿��� �����մϴ�.
			vo.setEmail(_email);
			dao.addMember(vo);
		}
		//command ���� delMember�� ��� ID�� ������ SQL������ �����ؼ� �����մϴ�.
		else if(command != null && command.equals("delMember"))
		{
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		
		//�ٽ� ��ȸ����.
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td><td>����</td></tr>");
	
		for(int i = 0; i <list.size(); i++) {
			MemberVO memberVO = (MemberVO)list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
		
			//������ Ŭ���ϸ� command ���� ȸ�� ID�� �������� �����մϴ�.
			out.print("<tr><td>" + id + "</td><td>" + pwd +"</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td>" + "<a href='/pro07/member3?command=delMember&id="+id+"'>����</a></td></tr>");
			
		}
		out.print("</table></body></html>");
		out.print("<a href = '/pro07/memberForm.html'>�� ȸ�� �����ϱ�</a>");
	}
	
}
