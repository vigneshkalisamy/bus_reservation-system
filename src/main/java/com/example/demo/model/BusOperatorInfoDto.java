package com.example.demo.model;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusOperatorInfoDto {
	
	@GeneratedValue
	private int id;
	
	@Id
	private int operatorCode;
	
	private String operatorName;
	
	private String sourceCity;
	
	private String destinationCity;
	
	private ZonedDateTime departureTime;
	
	private int travelDuration;
	
	private Date travelDate;
	
	private int price;
	
	private int busSeatingCapacity;
	
	private List<BusSeatingArrangement> occupiedPassengers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(int operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public ZonedDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(ZonedDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBusSeatingCapacity() {
		return busSeatingCapacity;
	}

	public void setBusSeatingCapacity(int busSeatingCapacity) {
		this.busSeatingCapacity = busSeatingCapacity;
	}

	public List<BusSeatingArrangement> getOccupiedPassengers() {
		return occupiedPassengers;
	}

	public void setOccupiedPassengers(List<BusSeatingArrangement> occupiedPassengers) {
		this.occupiedPassengers = occupiedPassengers;
	}

}
