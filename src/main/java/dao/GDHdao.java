package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Clothes;
import dto.Order;

public class GDHdao {

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

	public String makeClcode() {
		System.out.println("dao - makeClcode() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "SELECT NVL(MAX(clcode),'CL00000') as CLCODE FROM clothes";
		String clcode = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				clcode = result.getString("CLCODE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(clcode.equals("CL00000")) {
			clcode = "CL00001";	
			}else {
				
			String codeName = clcode.substring(0,2);
			int codeNum = Integer.parseInt(clcode.substring(2))+1;
			String codeNum_String = String.format("%05d", codeNum);
			clcode = codeName + codeNum_String;
			}
			System.out.println(clcode);
		return clcode;
	}

	public int insertAddProduct(Clothes clothes) {
		System.out.println("dao - insertAddProduct() 호출");
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		String sql = "INSERT INTO CLOTHES(CLCODE,CNAME,CTYPE,CPRICE,CAMOUNT,CSIZE,CLINFO,CLPHOTO,CSTATE)"
				+ " VALUES (?,?,?,?,?,?,?,?,'1')";
		int result=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,clothes.getClcode());
			pstmt.setString(2,clothes.getCname());
			pstmt.setString(3,clothes.getCtype());
			pstmt.setString(4,clothes.getCprice());
			pstmt.setString(5,clothes.getCamount());
			pstmt.setString(6,clothes.getCsize());
			pstmt.setString(7,clothes.getClinfo());
			pstmt.setString(8,clothes.getClphoto());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Clothes> selectClothes(String ctype) {
		System.out.println("dao - selectClothes() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select * from clothes where ctype = ? and cstate = '1' ";
		ArrayList<Clothes> ClothesList = new ArrayList<Clothes>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctype);
			ResultSet result = pstmt.executeQuery();
			Clothes cl = null;
			while(result.next()) {
				cl = new Clothes();
				cl.setClcode(result.getString("CLCODE"));
				cl.setCname(result.getString("CNAME"));
				cl.setCtype(result.getString("CTYPE"));
				cl.setCprice(result.getString("CPRICE"));
				cl.setCamount(result.getString("CAMOUNT"));
				cl.setCsize(result.getString("CSIZE"));
				cl.setClinfo(result.getString("CLINFO"));
				cl.setClphoto(result.getString("CLPHOTO"));
				ClothesList.add(cl);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ClothesList;
	}

	public Clothes selectDetail(String clcode) {
		System.out.println("dao - selectDetail() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select * from clothes where clcode = ?";
		Clothes cl = new Clothes();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clcode);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				cl = new Clothes();
				cl.setClcode(result.getString("CLCODE"));
				cl.setCname(result.getString("CNAME"));
				cl.setCtype(result.getString("CTYPE"));
				cl.setCprice(result.getString("CPRICE"));
				cl.setCamount(result.getString("CAMOUNT"));
				cl.setCsize(result.getString("CSIZE"));
				cl.setClinfo(result.getString("CLINFO"));
				cl.setClphoto(result.getString("CLPHOTO"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	public ArrayList<Clothes> selectSearch(String searchVal) {
		System.out.println("dao - selectSearch() 호출");
		Connection con = getConnection();
		if(con == null) {
			return null;
		}
		String sql = "select * from clothes where cname like ? ";
		ArrayList<Clothes> ClothesList = new ArrayList<Clothes>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchVal+"%");
			ResultSet result = pstmt.executeQuery();
			Clothes cl = null;
			while(result.next()) {
				cl = new Clothes();
				cl.setClcode(result.getString("CLCODE"));
				cl.setCname(result.getString("CNAME"));
				cl.setCtype(result.getString("CTYPE"));
				cl.setCprice(result.getString("CPRICE"));
				cl.setCamount(result.getString("CAMOUNT"));
				cl.setCsize(result.getString("CSIZE"));
				cl.setClinfo(result.getString("CLINFO"));
				cl.setClphoto(result.getString("CLPHOTO"));
				ClothesList.add(cl);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ClothesList;
	}
}
