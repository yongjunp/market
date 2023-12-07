package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Cadd;
import dto.Member;
import dto.Order;
import service.PYJservice;

/**
 * Servlet implementation class PYJcontroller
 */
@WebServlet({"/", "/Login","/Join", "/memLogin", "/Logout", "/my", "/orderForm","/addCart", "/cart","/deleteCadd", "/rsp", "/sendRSP"})
public class PYJcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PYJcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		String path = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		// 회원 관련 기능 SERVICE
		
		PYJservice PYJsvc = new PYJservice();
		Order od = new Order();
		HttpSession session = request.getSession();
		System.out.println("url : "+url);
		switch (url) {
		case "/":
			response.sendRedirect(path + "/main.jsp");
			break;
		case "/Login":
			response.sendRedirect(path + "/Login.jsp");
			break;
		case "/Join":
			response.sendRedirect(path + "/Join.jsp");
			break;
		case "/memLogin":
			System.out.println("로그인 요청");
			String LoginId = request.getParameter("username");
			String LoginPw = request.getParameter("password");
			System.out.println("입력한 아이디 : " + LoginId);
			System.out.println("입력한 비밀번호 : " + LoginPw);
			// 1. 아이디, 비밀번호 파라메터 확인

			// 2. SERVICE - 회원정보를 조회
			// SELECT * FROM MEMBERS WHERE MID = ? AND MPW = ?;
			Member memInfo = PYJsvc.LoginMemCheck(LoginId, LoginPw);
			System.out.println(memInfo);
			if (memInfo==null) {
				System.out.println("로그인 실패");
				response.sendRedirect(path+"/Login.jsp");
			} else {
				System.out.println("로그인 성공");
				System.out.println(memInfo);
				session.setAttribute("LoginMemId", memInfo.getMid());
				session.setAttribute("LoginMemPw", memInfo.getMpw());
				session.setAttribute("LoginMemName", memInfo.getMname());
				session.setAttribute("LoginMemAddr", memInfo.getAddress());
				session.setAttribute("LoginMemPhone", memInfo.getPhone());
				session.setAttribute("LoginMemEmail", memInfo.getMemail());
				session.setAttribute("LoginMstate", memInfo.getMstate());
				session.setAttribute("LoginMemCount", memInfo.getMcount());
				session.setAttribute("LoginMemPoint", memInfo.getMpoint());
				System.out.println(session.getAttribute("LoginMemId"));
				
				response.sendRedirect(path + "/main.jsp");
				// 로그인 처리 - 세션
			}
			break;
		case "/memJoin":
			System.out.println("회원가입 요청");

			Member joinMember = new Member();
			joinMember.setMid(request.getParameter("id"));
			joinMember.setMpw(request.getParameter("pw"));
			joinMember.setMname(request.getParameter("name"));
			joinMember.setPhone(request.getParameter("phone"));
			joinMember.setMemail(request.getParameter("email"));
			joinMember.setAddress(request.getParameter("address"));

			System.out.println(joinMember);
			int joinService = PYJsvc.joinService(joinMember);
			if (joinService > 0) {
				System.out.println("회원가입 성공");
				response.sendRedirect(path + "/main.jsp");
			} else {
				System.out.println("회원가입 실패");
				response.sendRedirect(
						path + "/Join.jsp");
			}
			break;
		case "/Logout":
			session.removeAttribute("LoginMemId"); // 로그인 정보 담기
			session.removeAttribute("LoginMemPw");
			session.removeAttribute("LoginMemName");
			session.removeAttribute("LoginMemAddr");
			session.removeAttribute("LoginMemPhone");
			session.removeAttribute("LoginMemEmail");
			session.removeAttribute("LoginMstate");
			session.removeAttribute("LoginMemCount");
			session.removeAttribute("LoginMemPoint");
			response.sendRedirect(path + "/main.jsp");
			break;
		case "/my":
			//주문내역 조회해서 보내기
			ArrayList<Order> orderList = PYJsvc.getOrder((String)session.getAttribute("LoginMemId"));
			request.setAttribute("orderList", orderList);
			System.out.println(session.getAttribute("LoginMemName"));
			request.getRequestDispatcher("my.jsp").forward(request, response);
			break;
		case "/orderForm":
			//주문코드 만들고 옷정보와 함께 주문페이지로 보내기 
			String odcode = PYJsvc.makeOdcode();
			request.setAttribute("odcode", odcode);
			request.getRequestDispatcher("a2.jsp").forward(request, response);
			break;
		case "/order":
			//주문 테이블에 넣고 수량만큼 옷테이블에서 빼기
			od.setOdcode(request.getParameter("ordercode"));
			od.setClcode(request.getParameter("goodsCode"));
			od.setMid(request.getParameter("MemId"));
			od.setAmount(request.getParameter("goodsAmount"));
			od.setPrice(request.getParameter("goodsPrice"));
			od.setCsize(request.getParameter("goodsSize"));
			od.setOdaddress(request.getParameter("address"));
			String mpoint = request.getParameter("mpoint");
			System.out.println(od);
			int rs = PYJsvc.OrderService(od);
			if(rs >0) {
				System.out.println("성공");
				PYJsvc.disMpoint(mpoint, od.getMid());
				boolean asd = Integer.parseInt(od.getPrice()) >=  15000;
				System.out.println("true : "+ asd);
				if(asd) {
					PYJsvc.addMcount((String)session.getAttribute("LoginMemId"));
				}
				request.getRequestDispatcher("main.jsp").forward(request, response);				
			}else {
				System.out.println("실패");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			break;
		case "/addCart":
			PrintWriter out = response.getWriter();
			Cadd cadd = new Cadd();
			cadd.setMid((String)request.getParameter("mid"));
			cadd.setClcode((String)request.getParameter("clcode"));
			cadd.setPrice((String)request.getParameter("price"));
			cadd.setCsize((String)request.getParameter("size"));
			cadd.setAmount((String)request.getParameter("amount"));
			System.out.println(cadd);
			int result = PYJsvc.addCadd(cadd);
			System.out.println(result);
			if(result >0) {
				out.print("success");
			}
			else {
				out.print("fail");
			}
			break;
		case "/cart":
			String mid = (String)session.getAttribute("LoginMemId");
			ArrayList<Cadd> caddList = PYJsvc.getCaddList(mid);
			request.setAttribute("caddList", caddList);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
			break;
		case "/deleteCadd":
			String adcode = request.getParameter("adcode");
			int caddDeleters = PYJsvc.deleteCadd(adcode);
			request.getRequestDispatcher("/cart").forward(request, response);
			break;
		case "/rsp":
			request.setAttribute("mcount", PYJsvc.getMcount((String)session.getAttribute("LoginMemId")));
			request.getRequestDispatcher("/rsp.jsp").forward(request, response);
			break;
		case "/sendRSP":
			Random randomGenerator = new Random();
			int randomInteger = randomGenerator.nextInt(3) + 1;
			String urlasd = null;
			switch (randomInteger) {
			case 1:
				urlasd = "https://i.namu.wiki/i/NGtKMmbKxdJDfzIVqpsP-4ATWzHrbcagd2h_NRj26Bz7YPzS-uU8kFxNgsgZQ3igFZXVLmPBBp3IB_P1HVVlaWBavf0UyLJ6FrPjKeGEQA3E9XMceLFOM0SQQpTflgmd834OGgqJ6GtWx2aIpcY7Hw.webp";
				break;
			case 2:
				urlasd = "http://cheonan.grandculture.net/Image?localName=cheonan&id=GC045P00213&t=middle";
				break;
			case 3:
				urlasd = "https://i.namu.wiki/i/cjYVX_1ZWXh97lRlyX_tlflWuHxK5NVE3-9rLuJtoZ1vXXpzOLxNyHulzpMWbZfindd8dTuJySUBC41cdoE63vutBpEGL-fgVhkFPeZ7dGxNdwhVeYQBZYW-aI2cfk0FFRyOu_sT3idWx4GDLJYHCA.webp";
				break;
			
			}
			PrintWriter aout = response.getWriter();
			String rsp = request.getParameter("rsp");
			String memberid = (String)session.getAttribute("LoginMemId");
			int rspResult = PYJsvc.rsp(rsp,memberid, randomInteger);
			System.out.println("rspResult : "+rspResult);
			switch (rspResult) {
			case 1:
				aout.print("drow+"+urlasd);
				break;

			case 2:
				//승리보상 증정
				PYJsvc.updateMporint(memberid);
				aout.print("win+"+urlasd);
				break;
			case 3:
				aout.print("Defeat+"+urlasd);
				break;
			}
			
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
