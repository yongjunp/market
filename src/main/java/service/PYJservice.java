package service;

import dto.Member;
import dto.Order;
import dao.PYJdao;
public class PYJservice {
	PYJdao pdao = new PYJdao();
	public Member LoginMemCheck(String loginId, String loginPw) {
		System.out.println("service - LoginMemCheck");
		Member memInfo = pdao.LoginCheckInfo(loginId,loginPw);
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
		return 0;
	}
}
