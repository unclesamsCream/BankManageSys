package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.usersDao;

public class userLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public userLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usersDao uDao = new usersDao();
		String account = request.getParameter("userAccount");
		String password = request.getParameter("userPassword");
		
		try {
			
			if(uDao.checkAccount(account, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("userAccount", account);
				response.sendRedirect(request.getContextPath() + "/users/userMain.jsp");
			}else{
				response.sendRedirect(request.getContextPath() + "/fail.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
