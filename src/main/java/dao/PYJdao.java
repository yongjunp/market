package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Cadd;
import dto.Member;
import dto.Order;
import oracle.security.o3logon.a;

public class PYJdao {

	Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userid = "Market";
		String userpw = "1111";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userid, userpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public Member LoginCheckInfo(String LoginId,String LoginPw) {
		System.out.println("dao - LoginCheckInfo() 호출");
		Connection con = getConnection();
		if(con == null) {
			return new Member();
		}
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
		Member member = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, LoginId);
			pstmt.setString(2, LoginPw);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setMid(rs.getString("MID"));
				member.setMpw(rs.getString("MPW"));
				member.setMname(rs.getString("MNAME"));
				member.setMemail(rs.getString("MEMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setMstate(rs.getString("MSTATE"));
				member.setMcount(rs.getString("MCOUNT"));
				member.setMpoint(rs.getString("MPOINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	public int insertMemberInfo(Member joinMember) {
		System.out.println("dao - insertMemberInfo() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "INSERT INTO MEMBER(MID,MPW,MNAME,MEMAIL,PHONE,ADDRESS, MSTATE, MPOINT, MCOUNT)"
				+ " VALUES (?,?,?,?,?,?,'1', 0, 0)";
		int result=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,joinMember.getMid());
			pstmt.setString(2,joinMember.getMpw());
			pstmt.setString(3,joinMember.getMname());
			pstmt.setString(4,joinMember.getMemail());
			pstmt.setString(5,joinMember.getPhone());
			pstmt.setString(6,joinMember.getAddress());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateClothes(Order od) {
		System.out.println("dao - updateClothes() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "update clothes set camount = camount - ? where clcode = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,od.getAmount());
			pstmt.setString(2, od.getClcode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int insertOrder(Order od) {
		System.out.println("dao - insertOrder() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "insert into corder(odcode, clcode, mid, oddate, amount, price, csize, odaddress, odstate)"
				+ "values(?, ?, ?, sysdate, ?, ? * ?, ?, ?, '1')";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,od.getOdcode());
			pstmt.setString(2,od.getClcode());
			pstmt.setString(3, od.getMid());
			pstmt.setString(4, od.getAmount());
			pstmt.setString(5, od.getAmount());
			pstmt.setString(6, od.getPrice());
			pstmt.setString(7, od.getCsize());
			pstmt.setString(8, od.getOdaddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String makeOdcode() {
		System.out.println("dao - makeOdcode() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "SELECT NVL(MAX(odcode),'OD00000') as ODCODE FROM corder";
		String odcode = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				odcode = result.getString("ODCODE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(odcode.equals("CD00000")) {
			odcode = "CD00001";	
			}else {
				
			String codeName = odcode.substring(0,2);
			int codeNum = Integer.parseInt(odcode.substring(2))+1;
			String codeNum_String = String.format("%05d", codeNum);
			odcode = codeName + codeNum_String;
			}
			System.out.println(odcode);
		return odcode;
	}

	public ArrayList<Order> selectOrder(String mid) {
		System.out.println("dao - insertOrder() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select * from corder where mid = ?";
		ArrayList<Order> OrderList = new ArrayList<Order>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mid);
			ResultSet result = pstmt.executeQuery();
			Order od = null;
			while(result.next()) {
				od = new Order();
				od.setOdcode(result.getString("ODCODE"));
				od.setClcode(result.getString("CLCODE"));
				od.setMid(result.getString("MID"));
				od.setOddate(result.getString("ODDATE"));
				od.setAmount(result.getString("AMOUNT"));
				od.setPrice(result.getString("PRICE"));
				od.setCsize(result.getString("CSIZE"));
				od.setOdaddress(result.getString("ODADDRESS"));
				od.setOdstate(result.getString("ODSTATE"));
				OrderList.add(od);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OrderList;
	}

	public int insertCadd(Cadd cadd) {
		System.out.println("dao - insertCadd() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "insert into cadd values(?, ?, ?, ?, ?, ?)";
		int rs = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,cadd.getAdcode());
			pstmt.setString(2,cadd.getMid());
			pstmt.setString(3,cadd.getClcode());
			pstmt.setInt(4,Integer.parseInt(cadd.getAmount()));
			pstmt.setInt(5,Integer.parseInt(cadd.getPrice()));
			pstmt.setString(6,cadd.getCsize());
			rs = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public String makeAdcode() {
		System.out.println("dao - makeOdcode() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "SELECT NVL(MAX(adcode),'AD00000') as ADCODE FROM cadd";
		String adcode = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				adcode = result.getString("ADCODE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(adcode.equals("AD00000")) {
			adcode = "AD00001";	
			}else {
				
			String codeName = adcode.substring(0,2);
			int codeNum = Integer.parseInt(adcode.substring(2))+1;
			String codeNum_String = String.format("%05d", codeNum);
			adcode = codeName + codeNum_String;
			}
			System.out.println(adcode);
		return adcode;
	}

	public ArrayList<Cadd> selectCadd(String mid) {
		System.out.println("dao - selectCadd() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select * from cadd inner join (select clcode, cname, camount as amount from clothes) cl on cadd.clcode = cl.clcode where mid =  ?";
		ArrayList<Cadd> caddList= new ArrayList<Cadd>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				Cadd cadd = new Cadd();
				cadd.setAdcode(result.getString("ADCODE"));
				cadd.setMid(result.getString("MID"));
				cadd.setClcode(result.getString("CNAME"));
				cadd.setAmount(result.getString("AMOUNT"));
				cadd.setPrice(result.getString("PRICE"));
				cadd.setCsize(result.getString("CSIZE"));
				System.out.println(cadd);
				caddList.add(cadd);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		return caddList;
	}

	public int deleteCadd(String adcode) {
		System.out.println("dao - selectCadd() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "delete from cadd where adcode = ?";
		int rs = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adcode);
			rs = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public String selectMcount(String mid) {
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select mcount from member where mid = ?";
		String rs = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				rs = result.getString("MCOUNT");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public void updateMcount(String memberid) {
		Connection con = getConnection();
		String sql = "update member set mcount = mcount -1 where mid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void updateMpoint(String memberid) {
		Connection con = getConnection();
		String sql = "update member set mpoint = mpoint +1000 where mid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void disMpoint(String mpoint, String mid) {
		Connection con = getConnection();
		int point = Integer.parseInt(mpoint);
		String sql = "update member set mpoint = mpoint - ? where mid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, mid);
			
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void addMcount(String mid) {
		Connection con = getConnection();
		System.out.println("mid : "+mid);
		String sql = "update member set mcount = mcount +1 where mid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			int rs = pstmt.executeUpdate();
					System.out.println(rs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
