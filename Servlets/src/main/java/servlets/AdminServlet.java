package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      // Actual logic goes here.
		      PrintWriter out = response.getWriter();
		      HttpSession session = request.getSession(false);
		      if (session != null && session.getAttribute("role").equals("ADMIN")) {
			      out.println(
			    		  "<!DOCTYPE html>"+
			    			"<head>" + 
			    	        "<title>Admin</title>" + 
			    	    "</head>" + 
			    	        "<body>" + 
			    		  	"<h1>" + "Admin Page" + "</h1>" +
			    	        " <form action = admin/flights method=get>" + 
			    	        "            <input type=submit value='Get flights'>" + 
			    	        "        </form>" +
			    	        "<h2>Create flight</h2>" + 
			    	        " <form action=admin/create method=post>" +
			    	        "            <label>Airplane Type</label>\r\n" + 
			    	        "            <select name=type>\r\n" + 
			    	        "                <option value = AIRBUS>Airbus</option>" + 
			    	        "                <option value = BOEING>Boeing</option>" + 
			    	        "            </select>" + 
			    	        "            <label>Departure City</label>\r\n" + 
			    	        "            <input type=text name=departure><br>" +  
			    	        "            <label>Arrival City</label>" + 
			    	        "            <input type=text name=arrival><br>" +  
			    	        "            <label>Departure time</label>" + 
			    	        "            <input type=datetime-local name=departureTime><br>" + 
			    	        "            <label>Arrival time</label>" + 
			    	        "            <input type=datetime-local name=arrivalTime><br>" +    	       
			    	        "            <br>" + 
			    	        "            <input type =submit value=Create>" + 
			    	        "        </form>" + 
			    	        " <h2>Update a flight</h2>" + 
			    	        "        <form action=admin/update method=post>" + 
			    	        "            <label>Flight ID</label>" + 
			    	        "            <input type=number name=updateFlightId>" + 
			    	        "            <select name=updateType>" + 
			    	        "                <option value = AIRBUS>Airbus</option>" + 
			    	        "                <option value = BOEING>Boeing</option>" + 
			    	        "            </select>" + 
			    	        "            <label>Departure City</label>" + 
			    	        "            <input type=text name=updateDeparture><br>" + 
			    	        "            <label>Arrival City</label>" + 
			    	        "            <input type=text name=updateArrival><br>" + 
			    	        "            <label>Departure time</label>" + 
			    	        "            <input type=datetime-local name=updateDepartureTime><br>" + 
			    	        "            <label>Arrival time</label>" + 
			    	        "            <input type=datetime-local name=updateArrivalTime><br>" + 
			    	        "            <input type = submit value=Update>" + 
			    	        "        </form>" + 
			    	        "<h2> Delete a flight</h2> " + 
			    	        "        <form action=admin/delete method=post>" + 
			    	        "            <label>Flight ID</label>" + 
			    	        "            <input type=number name=deleteFlightId>" + 
			    	        "            <input type = submit value=Delete>" + 
			    	        "        </form>" + 
			    	        "</body" + 
			    	        "</html>"
	
			    	        );
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
