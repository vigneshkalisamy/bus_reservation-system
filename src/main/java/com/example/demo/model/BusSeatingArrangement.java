package com.example.demo.model;

import lombok.Data;

@Data
public class BusSeatingArrangement {
	
	private int seatNumber;
	
	private String personName;
	
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	
	

}
