package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";
	private Connection con;
	//private Statement stmt;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");//JNDI�� �����ϱ� ���� �⺻ ���("java:/comp/env")�� ����.
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");//��Ĺ context.xml�� ������ name ���� jdbc/oracle�� �̿���
			 															//��Ĺ�� �̸� ������ DataSource�� �޾� �ɴϴ�.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection(); //DataSource�� �̿��� �����ͺ��̽��� �����մϴ�.
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();	//���̺� ������ ȸ�������� �޾ƿɴϴ�.
			
			String query = "insert into t_member"; //Insert���� ���ڿ��� ����ϴ�.
			query +=  " (id, pwd, name, email)";
			query +=  " values(?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);   //insert���� �� '?'�� ������� ȸ�������� �����մϴ�.
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate(); //ȸ�� ������ ���̺� �߰��մϴ�.
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id)
	{
		try {
			Connection con = dataFactory.getConnection();
			//Statement stmt = con.createStatement();
			
			String query = "delete from t_member" + " where id=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers()
	{
		List list = new ArrayList();
		try {
			//connDB();
			con = dataFactory.getConnection(); //DataSource�� �̿��� �����ͺ��̽��� ����.
			String query = "select*from t_member";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) 
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle ����̹� �ε� ����");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection ���� ����");
//		//	stmt = con.createStatement();
//		//	System.out.println("Statement ���� ����");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
