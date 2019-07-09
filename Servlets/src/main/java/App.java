import data.dao.CityDao;
import data.dao.FlightDao;
import data.dao.UserDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import data.beans.City;
import data.beans.Flight;
import data.beans.User;

public class App {

	public static void main(String [] args) {
		
	City city1 = new City();
	CityDao cityDao = new CityDao();
	city1.setLatitude(45.234);
	city1.setLongitude(34.323);
	city1.setName("Bucharest");
	cityDao.createCity(city1);
	
	City city2 = new City();
	city2.setLatitude(98.324);
	city2.setLongitude(1.231);
	city2.setName("London");
	cityDao.createCity(city2);
	
	
		
	}
}
