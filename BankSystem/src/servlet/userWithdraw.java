package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.userAction;
import dao.usersDao;

public class userWithdraw extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public userWithdraw() {
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
		
		String account = request.getParameter("userAccount");
		float amount = Float.parseFloat(request.getParameter("withdrawAmount"));
		usersDao ud = new usersDao();
		PrintWriter out = response.getWriter();
		
		try {
			if(ud.checkResidual(account, amount))
			{
				userAction ua = new userAction();
				ua.withdraw(account, amount);
				response.sendRedirect(request.getContextPath() + "/users/withdrawOk.jsp");
				
			}else{
				response.sendRedirect(request.getContextPath() + "/users/wrong.jsp");
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
