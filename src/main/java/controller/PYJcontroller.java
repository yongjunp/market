package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;
import dto.Order;
import service.PYJservice;

/**
 * Servlet implementation class PYJcontroller
 */
@WebServlet({"/", "/Login","/Join", "/memLogin", "/Logout", "/my", "/orderForm"})
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
			response.sendRedirect(path + "/NewFile1.jsp");
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
				session.setAttribute("LoginMemId", memInfo.getMid());
				session.setAttribute("LoginMemPw", memInfo.getMpw());
				session.setAttribute("LoginMemName", memInfo.getMname());
				session.setAttribute("LoginMemAddr", memInfo.getAddress());
				session.setAttribute("LoginMemPhone", memInfo.getPhone());
				session.setAttribute("LoginMemEmail", memInfo.getMemail());
				System.out.println(session.getAttribute("LoginMemId"));
				
				response.sendRedirect(path + "/NewFile1.jsp");
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
				response.sendRedirect(path + "/NewFile1.jsp");
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
			
			response.sendRedirect(path + "/NewFile1.jsp");
			break;
		case "/my":
			//주문내역 조회해서 보내기
			request.getRequestDispatcher("my.jsp").forward(request, response);
			break;
		case "/orderForm":
			//주문코드 만들고 옷정보와 함께 주문페이지로 보내기 
			request.getRequestDispatcher("a2.jsp").forward(request, response);
			break;
		case "/order":
			//주문 테이블에 넣고 수량만큼 옷테이블에서 빼기
			od.setClcode(request.getParameter("goodsCode"));
			od.setMid(request.getParameter("goodsCode"));
			od.setAmount(request.getParameter("goodsAmount"));
			od.setPrice(request.getParameter("goodsPrice"));
			od.setCsize(request.getParameter("goodsSize"));
			od.setOdaddress(request.getParameter("address"));
			int rs = PYJsvc.OrderService(od);
			request.getRequestDispatcher("NewFile1.jsp").forward(request, response);
			break;
		case "/cartOrder":
			
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
