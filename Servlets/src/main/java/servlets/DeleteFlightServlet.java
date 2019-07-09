package servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import data.dao.FlightDao;

public class DeleteFlightServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("role").equals("ADMIN")) {
			FlightDao flightDao = new FlightDao();
			flightDao.deleteFlight(Integer.parseInt(request.getParameter("deleteFlightId")));
	    } else {
	    	out.println("<!DOCTYPE html>" +
				      "<head>" + 
				    		  "<title>All Flights</title>" +
				      "</head>" + 
				    		  "<body>" +
				    		  "<a class=\"btn\" href=login>" + "Back" + "</a>" + 
				    		  "</body>" + 
				    		  "</html>");
	    }
	}
}
