package sec03.ex01;

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
	
	public List listMembers(String id, String vid)
	{
		List list = new ArrayList();
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query="SELECT prod_id,prod_name,prod_price,prod_desc,vend_id";
			query += " FROM products";
			query += " WHERE 1=1 ";
			if(id != null && !"".equals(id)){
			   query += " AND prod_id LIKE '%"+id+"%'";
			}
			if(id != null && !"".equals(id)){
			   query += "  AND vend_id LIKE '%"+vid+"%'";
			}
//			String query = "select p.prod_id, p.prod_name, p.prod_price, p.prod_desc, v.vend_name, v.vend_id" +
//							" FROM products p, vendors v" + 
//							" WHERE p.vend_id = v.vend_id" +
//						//" AND b.order_num = a.order_num" +
//						//" AND a.prod_id = d.prod_id" +
//							" AND p.prod_id like '%" + id + "%'" +
//							" AND v.vend_id like '%" + vid + "%'";
				
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);	
			
			while(rs.next()) 
			{
				String prod_id = rs.getString("prod_id");
				String prod_name = rs.getString("prod_name");
				String prod_price = rs.getString("prod_price");
				String prod_desc = rs.getString("prod_desc");
				String vend_name = rs.getString("vend_name");
				String vend_id = rs.getString("vend_id");
	
				MemberVO vo = new MemberVO();
				vo.setProd_id(prod_id);;
				vo.setProd_name(prod_name);
				vo.setProd_price(prod_price);
				vo.setProd_desc(prod_desc);
				vo.setVend_name(vend_name);
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
	
//	public List listOrders(String cust_id)
//	{
//		List list = new ArrayList();
//		try {
//			connDB();
//			String query = "select b.order_num, d.prod_name, a.quantity, a.item_price, d.prod_id" +
//					" FROM orderitems a, orders b, customers c, products d" + 
//					" WHERE c.cust_id = b.cust_id" +
//					" AND b.order_num = a.order_num" +
//					" AND a.prod_id = d.prod_id" +
//					" AND c.cust_id = '" + cust_id + "'";
//			System.out.println(query);
//			pstmt = con.prepareStatement(query);
//			ResultSet rs = pstmt.executeQuery(query);
//			
//			while(rs.next()) 
//			{
//				//String cust_id = rs.getString("cust_id");
//				//String cust_name = rs.getString("cust_name");
//				String order_num = rs.getString("order_num");
//				String prod_id = rs.getString("prod_id");
//				String prod_name = rs.getString("prod_name");
//				//String cust_address = rs.getString("cust_address");
//				String quantity = rs.getString("quantity");
//				String item_price = rs.getString("item_price");
//				
//				MemberVO vo = new MemberVO();
//				//vo.setCust_id(cust_id);;
//				//vo.setCust_name(cust_name);
//				vo.setOrder_num(order_num);
//				vo.setProd_id(prod_id);
//				vo.setProd_name(prod_name);
//				//vo.setCust_address(cust_address);
//				vo.setQuantity(quantity);
//				vo.setItem_price(item_price);
//				list.add(vo);
//			}
//			rs.close();
//			pstmt.close();
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//		
//	}
//	
	public void delMember(String id)
	{
		try {
			System.out.println("�Ƶ�" + id);
			Connection con = dataFactory.getConnection();
			//Statement stmt = con.createStatement();
			
			String query = "delete from products" + " where TRIM(prod_id)=?";
			System.out.println("prepareStatememt:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection(); //DataSource�� �̿��� �����ͺ��̽��� �����մϴ�.
			String id = memberVO.getProd_id();
			String name = memberVO.getProd_name();
			double price = Double.parseDouble(memberVO.getProd_price());
			String desc = memberVO.getProd_desc();	//���̺� ������ ȸ�������� �޾ƿɴϴ�.
			String vendid = memberVO.getVend_id();
			System.out.println(id + " " + name + " "+ price + " "+desc + " "+vendid);
			
			
			String query = "insert into products"; //Insert���� ���ڿ��� ����ϴ�.
			query +=  " (prod_id, prod_name, prod_price, prod_desc, vend_id)";
			query +=  " values(?,?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);   //insert���� �� '?'�� ������� ȸ�������� �����մϴ�.
			pstmt.setString(2, name);
			pstmt.setDouble(3, price);
			pstmt.setString(4, desc);
			pstmt.setString(5, vendid);
			pstmt.executeUpdate(); //ȸ�� ������ ���̺� �߰��մϴ�.
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	
//	public void delOrder(String order_num, String prod_id)
//	{
//		try {
//			Connection con = dataFactory.getConnection();
//			//Statement stmt = con.createStatement();
//			
//			String query = "delete from orderitems" + " where order_num='" + order_num + "' and prod_id='"+prod_id + "'";
//			System.out.println("prepareStatememt:" + query);
//			pstmt = con.prepareStatement(query);
////			pstmt.setString(1, order_num);
////			pstmt.setString(2, prod_id);
//			pstmt.executeUpdate();
//			pstmt.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
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
