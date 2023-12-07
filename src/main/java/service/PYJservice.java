package service;

import java.util.ArrayList;
import java.util.Random;

import dao.PYJdao;
import dto.Cadd;
import dto.Member;
import dto.Order;

public class PYJservice {
	PYJdao pdao = new PYJdao();

	public Member LoginMemCheck(String loginId, String loginPw) {
		System.out.println("service - LoginMemCheck");
		Member memInfo = pdao.LoginCheckInfo(loginId, loginPw);
		return memInfo;
	}

	public int joinService(Member joinMember) {
		System.out.println("service - joinService() 호출");
		int joinResult = pdao.insertMemberInfo(joinMember);
		return joinResult;
	}

	public int OrderService(Order od) {
		System.out.println("service - orderService() 호출");
		int rs = pdao.updateClothes(od);
		int result = 0;

		System.out.println(od);
		if (rs > 0) {
			result = pdao.insertOrder(od);
		}
		return result;
	}

	public String makeOdcode() {
		String odcode = pdao.makeOdcode();
		return odcode;
	}

	public ArrayList<Order> getOrder(String mid) {
		System.out.println("service = getOrder() 호출");
		return pdao.selectOrder(mid);
	}

	public int addCadd(Cadd cadd) {
		System.out.println("service - addCadd");
		String adcode = pdao.makeAdcode();
		cadd.setAdcode(adcode);
		System.out.println("asd");
		System.out.println(cadd);
		return pdao.insertCadd(cadd);
	}

	public ArrayList<Cadd> getCaddList(String mid) {
		System.out.println("service - getCaddList");
		return pdao.selectCadd(mid);
	}

	public int deleteCadd(String adcode) {
		System.out.println("service - deleteCadd()");
		return pdao.deleteCadd(adcode);
	}

	public int rsp(String rsp, String memberid, int randomInteger) {
		System.out.println("service - rsp()");
		
		int rs = 0; //비김:1 이김:2, 짐:3
		switch (randomInteger) {
		case 1:
			switch (rsp) {
			case "가위":
				rs = 1;
				break;
			case "바위":
				rs = 2;
				break;
			case "보":
				rs = 3;
				break;
			}
			break;
		case 2:
			switch (rsp) {
			case "가위":
				rs = 3;
				break;
			case "바위":
				rs = 1;
				break;
			case "보":
				rs = 2;
				break;
			}
			break;
		case 3:
			switch (rsp) {
			case "가위":
				rs = 2;
				break;
			case "바위":
				rs = 3;
				break;
			case "보":
				rs = 1;
				break;
			}
			break;
		}
		pdao.updateMcount(memberid);
		return rs;
	}

	public String getMcount(String mid) {
		System.out.println("service - getMcount()");
		return pdao.selectMcount(mid);
	}

	public void updateMporint(String memberid) {
		pdao.updateMpoint(memberid);
		
	}

	public void disMpoint(String mpoint, String mid) {
		pdao.disMpoint(mpoint, mid);
		
	}

	public void addMcount(String mid) {
		System.out.println("service - addMcount()");
		pdao.addMcount(mid);
		
	}
}
