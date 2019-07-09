package data.beans;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity		
@Table(name = "FLIGHT")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "airplane_type")
	private String airplaneType;
	
	@Column (name = "departure_city")
	private String departureCity;
	
	@Column (name = "arrival_city")
	private String arrivalCity;
	
	@Column(name = "departure_hour")
	private LocalDateTime departureHour;
	
	@Column(name = "arrival_hour")
	private LocalDateTime arrivalHour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDateTime getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(LocalDateTime departureHour) {
		this.departureHour = departureHour;
	}

	public LocalDateTime getArrivalHour() {
		return arrivalHour;
	}

	public void setArrivalHour(LocalDateTime arrivalHour) {
		this.arrivalHour = arrivalHour;
	}
	
}
