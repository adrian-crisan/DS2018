package servlets;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import data.beans.Flight;
import data.dao.FlightDao;

public class GetFlightsServlet extends HttpServlet {

static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      // Actual logic goes here.
		      PrintWriter out = response.getWriter();
		      
		      FlightDao flightDao = new FlightDao();
		      List<Flight> flights = flightDao.findAll();
		      
		      HttpSession session = request.getSession(false);
		      if (session != null && session.getAttribute("role").equals("ADMIN")) {
			      out.println("<!DOCTYPE html>" +
			      "<head>" + 
			    		  "<title>All Flights</title>" +
			      "</head>" + 
			    		  "<body>" +
			    		  	"<table>" + 
			    		    "<tr>" + 
			    		  	"<th>Flight Number</th>" +
			    		  	"<th>Airplane Type</th>" + 
			    		  	"<th>Departure City</th>" + 
			    		  	"<th>Arrival City</th>" + 
			    		  	"<th>Departure Time</th>" + 
			    		  	"<th>Arrival Time</th>" + 
			    		  	"</tr>");
			      for (Flight flight : flights) {
			    	  out.println("<tr>" + 
			    			  		"<td>" + flight.getId() + "</td>" + 
			    			  		"<td>" + flight.getAirplaneType() + "</td>" + 
			    			  		"<td>" + flight.getDepartureCity() + "</td>" + 
			    			  		"<td>" + flight.getArrivalCity() + "</td>" + 
			    			  		"<td>" + flight.getDepartureHour() +"\t"+ "</td" + 
			    			  		"<td>" + flight.getArrivalHour() + "</td>" + 
			    			  		"</tr>");
			      }
			      out.println("</table>" + 
			    		  		"</body>" + 
			    		  		"</html>");
		      }
		      else {
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
