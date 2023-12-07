package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Clothes;
import dto.Order;
import service.GDHservice;
import service.PYJservice;

/**
 * Servlet implementation class GDHcontroller
 */
@WebServlet({"/addproduct", "/upper", "/under", "/outer", "/shoes", "/cap", "/detailPage", "/searchPage"})
public class GDHcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GDHcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String path = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		// 회원 관련 기능 SERVICE
		
		GDHservice GDHsvc = new GDHservice();
		Order od = new Order();
		HttpSession session = request.getSession();
		System.out.println("url : " + url);
		Clothes clothes = new Clothes();
		switch (url) {
		case "/searchPage":			
			String searchVal = request.getParameter("search");
			java.net.URLDecoder.decode(searchVal,"UTF-8");
			System.out.println(searchVal);
			ArrayList<Clothes> searchList = GDHsvc.searchClothes(searchVal);
			System.out.println(searchList);
			request.setAttribute("searchVal", searchVal);
			request.setAttribute("clothes", searchList);
			request.getRequestDispatcher("searchPage.jsp").forward(request, response);
			
			break;
			
		case "/addproduct":
			String clcode = GDHsvc.makeClcode();
			clothes.setClcode(clcode);
			clothes.setCname(request.getParameter("name"));
			clothes.setCtype(request.getParameter("type"));
			clothes.setCamount(request.getParameter("amount"));
			clothes.setCprice(request.getParameter("price"));
			clothes.setClinfo(request.getParameter("info"));
			clothes.setCsize(request.getParameter("size"));
			clothes.setClphoto(request.getParameter("photo"));
			System.out.println(clothes);
			int addService = GDHsvc.addService(clothes);
			if (addService > 0) {
				System.out.println("상품추가 성공");
				response.sendRedirect(path + "/main.jsp");
				
			} else {
				System.out.println("상품추가 실패");
				response.sendRedirect(
						path + "/addproduct.jsp");
			}
			
			break;
		case "/upper":
			String ctype = "상의";
			ArrayList<Clothes> upper = GDHsvc.selectUpper(ctype);
			System.out.println(upper);
			request.setAttribute("clothes", upper);
			request.getRequestDispatcher("upper.jsp").forward(request, response);
			
			break;
		case "/under":
			ctype = "하의";
			ArrayList<Clothes> under = GDHsvc.selectUpper(ctype);
			System.out.println(under);
			request.setAttribute("clothes", under);
			request.getRequestDispatcher("under.jsp").forward(request, response);
			
			break;
		case "/outer":
			ctype = "아우터";
			ArrayList<Clothes> outer = GDHsvc.selectUpper(ctype);
			System.out.println(outer);
			request.setAttribute("clothes", outer);
			request.getRequestDispatcher("outer.jsp").forward(request, response);
			
			break;
		case "/shoes":
			ctype = "신발";
			ArrayList<Clothes> shoes = GDHsvc.selectUpper(ctype);
			System.out.println(shoes);
			request.setAttribute("clothes", shoes);
			request.getRequestDispatcher("shoes.jsp").forward(request, response);
			
			break;
		case "/cap":
			ctype = "모자";
			ArrayList<Clothes> cap = GDHsvc.selectUpper(ctype);
			System.out.println(cap);
			request.setAttribute("clothes", cap);
			request.getRequestDispatcher("cap.jsp").forward(request, response);
			
			break;
			
		case "/detailPage":
			String Clcode = request.getParameter("Clcode");
			System.out.println("Clcode : " + Clcode);
			Clothes detail = GDHsvc.detailPage(Clcode);
			System.out.println(detail);
			request.setAttribute("clothes", detail);
			request.getRequestDispatcher("NewFile222.jsp").forward(request, response);
			
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
