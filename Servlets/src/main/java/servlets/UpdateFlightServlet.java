package servlets;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.*;
import javax.servlet.http.*;

import data.beans.Flight;

import data.dao.FlightDao;

public class UpdateFlightServlet extends HttpServlet {

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
			flight.setId(Integer.parseInt(request.getParameter("updateFlightId")));
			flight.setAirplaneType(request.getParameter("updateType"));
			flight.setDepartureCity(request.getParameter("updateDeparture"));
			flight.setArrivalCity(request.getParameter("updateArrival"));
			flight.setDepartureHour(LocalDateTime.parse(request.getParameter("updateDepartureTime"), formatter));
			flight.setArrivalHour(LocalDateTime.parse(request.getParameter("updateArrivalTime"), formatter));
			flightDao.updateFlight(flight);
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
