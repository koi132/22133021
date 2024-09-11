package Controller.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Controller.dao.Accont;
import Controller.dao.CheckLogin;

/**
 * Servlet implementation class FormLogin
 */

@WebServlet(urlPatterns = { "/login" })
public class FormLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormLogin() {
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
    		String pass = request.getParameter("password");
    		CheckLogin login = new CheckLogin();
    		PrintWriter out = response.getWriter();
    		Accont a = login.checkLogin(user, pass);
    		
    		if(a == null) {
    			out.println("Đăng nhập không thành công");
    			
    		}else {
    			out.println("Đăng nhập thành công");
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
