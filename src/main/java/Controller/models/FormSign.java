package Controller.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Controller.dao.Accont;
import Controller.dao.CheckLogin;
import Controller.dao.CheckSign;

/**
 * Servlet implementation class FormSign
 */
@WebServlet(urlPatterns = { "/sign" })
public class FormSign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	      response.setCharacterEncoding("UTF-8");
	      request.setCharacterEncoding("UTF-8"); 
		try {
  		String user = request.getParameter("username");
  		String id = request.getParameter("id");
  		String image = request.getParameter("image");
  		String fullname = request.getParameter("fullname");
  		String pass = request.getParameter("password");
  		CheckSign sign = new CheckSign();
  		PrintWriter out = response.getWriter();
  		boolean a = sign.checkSign(id,user, pass,fullname,image);
  		
  		if(a == false) {
  			out.println("Đăng ký không thành công");
  			
  		}else {
  			out.println("Đăng ký thành công");
  			response.sendRedirect("/Login/Login.html");
  			
  		}
  	}catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
