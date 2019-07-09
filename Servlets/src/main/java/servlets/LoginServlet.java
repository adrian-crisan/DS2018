package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import data.dao.UserDao;
import data.beans.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
		   RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
	       requestDispatcher.forward(request, response);
	   }

	   public void doPost(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {

		   response.setContentType("text/html");

	       String username = request.getParameter("username");
	       String password = request.getParameter("password");
	       
	       UserDao userDao = new UserDao();
	       User toFind = userDao.findByUsername(username);
	       
	       if (toFind != null && password.equals(toFind.getPassword())) {
	    	   HttpSession session = request.getSession();
	    	   session.setAttribute("role", toFind.getRole());
	    	   if (toFind.getRole().equals("ADMIN")) {
	    		   response.sendRedirect("admin");
	    	   }
	    	   else if (toFind.getRole().equals("USER")) {
	    		   response.sendRedirect("user");
	    	   }
	    	   else {
	    		   response.sendRedirect("login");
	    	   }
	       }
	       else {
	    	   response.sendRedirect("login");
	       }
	       
	   }
	   
	   public void destroy() {
	      // do nothing.
	   }
}
