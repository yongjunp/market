package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;
import dto.Order;

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
		String sql = "INSERT INTO MEMBER(MID,MPW,MNAME,MEMAIL,PHONE,ADDRESS, MSTATE)"
				+ " VALUES (?,?,?,?,?,?,'1')";
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
		String sql = "update clothes set camount = camout - ? where clcode = ?";
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

}
