package service;

import java.util.ArrayList;

import dao.GDHdao;
import dto.Clothes;

public class GDHservice {
	GDHdao gdao = new GDHdao();
	public String makeClcode() {
		String clcode = gdao.makeClcode();
		return clcode;
	}
	public int addService(Clothes clothes) {
		System.out.println("service - addService 호출");
		int addResult = gdao.insertAddProduct(clothes);
		return addResult;
	}
	public ArrayList<Clothes> selectUpper(String ctype) {
		System.out.println("service - selectUpper 호출");
		
		return gdao.selectClothes(ctype);
	}
	public Clothes detailPage(String clcode) {
		System.out.println("service - detailPage() 호출");
		
		return gdao.selectDetail(clcode);
	}
	public ArrayList<Clothes> searchClothes(String searchVal) {
		System.out.println("service - searchClothes() 호출");
		
		return gdao.selectSearch(searchVal);
	}

}
