//package sec01.ex01;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//public class MemberDAO {
//
//	private static final String driver= "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private static final String user ="scott";
//	private static final String pwd = "tiger";
//	private Connection con;
//	private PreparedStatement pstmt;
//	private DataSource dataFactory;
//	
//	public MemberDAO() {
//		try {
//			Context ctx = new InitialContext();
//			Context envContext = (Context)ctx.lookup("java:/comp/env");//JNDI에 접근하기 위해 기본 경로("java:/comp/env")를 지정.
//			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");//톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해
//			 															//톰캣에 미리 연결한 DataSource를 받아 옵니다.
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public List listMembers(String id)
//	{
//		List list = new ArrayList();
//		try {
//			connDB();
//			String query = "select c.cust_id, c.cust_name, c.cust_address" +
//					" FROM customers c" + 
//					//" WHERE c.cust_id = b.cust_id" +
//					//" AND b.order_num = a.order_num" +
//					//" AND a.prod_id = d.prod_id" +
//					" WHERE c.cust_id = '" + id + "'";
//			System.out.println(query);
//			pstmt = con.prepareStatement(query);
//			ResultSet rs = pstmt.executeQuery(query);
//			
//			while(rs.next()) 
//			{
//				String cust_id = rs.getString("cust_id");
//				String cust_name = rs.getString("cust_name");
//				//String order_num = rs.getString("order_num");
//				//String prod_id = rs.getString("prod_id");
//				//String prod_name = rs.getString("prod_name");
//				String cust_address = rs.getString("cust_address");
//				//String quantity = rs.getString("quantity");
//				//String item_price = rs.getString("item_price");
//				
//				MemberVO vo = new MemberVO();
//				vo.setCust_id(cust_id);;
//				vo.setCust_name(cust_name);
//				//vo.setOrder_num(order_num);
//				//vo.setProd_id(prod_id);
//				//vo.setProd_name(prod_name);
//				vo.setCust_address(cust_address);
//				//vo.setQuantity(quantity);
//				//vo.setItem_price(item_price);
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
//	public void delMember(String id)
//	{
//		try {
//			Connection con = dataFactory.getConnection();
//			//Statement stmt = con.createStatement();
//			
//			String query = "delete from customers" + " where cust_id=?";
//			System.out.println("prepareStatememt:" + query);
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, id);
//			pstmt.executeUpdate();
//			pstmt.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
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
//			System.out.println("Oracle 드라이버 로딩 성공");
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//		//	stmt = con.createStatement();
//		//	System.out.println("Statement 생성 성공");
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//}
