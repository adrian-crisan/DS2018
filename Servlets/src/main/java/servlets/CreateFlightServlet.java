package servlets;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.*;
import javax.servlet.http.*;

import data.beans.Flight;
import data.dao.FlightDao;

public class CreateFlightServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("role").equals("ADMIN")) {
			Flight flight = new Flight();
			FlightDao flightDao = new FlightDao();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			flight.setAirplaneType(request.getParameter("type"));
			flight.setDepartureCity(request.getParameter("departure"));
			flight.setArrivalCity(request.getParameter("arrival"));
			flight.setDepartureHour(LocalDateTime.parse(request.getParameter("departureTime"), formatter));
			flight.setArrivalHour(LocalDateTime.parse(request.getParameter("arrivalTime"), formatter));
			flightDao.createFlight(flight);
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
