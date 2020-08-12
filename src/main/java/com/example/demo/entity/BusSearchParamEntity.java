package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class BusSearchParamEntity {
	
	private String sourceCity;
	
	private String destinationCity;
	
	private Date travelDate;
	
	private Date returnTravelDate;
	
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

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Date getReturnTravelDate() {
		return returnTravelDate;
	}

	public void setReturnTravelDate(Date returnTravelDate) {
		this.returnTravelDate = returnTravelDate;
	}

	

}
