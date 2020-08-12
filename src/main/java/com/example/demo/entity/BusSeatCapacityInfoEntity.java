package com.example.demo.entity;

import java.util.List;

public class BusSeatCapacityInfoEntity {
	
	List<Integer> bookedSeats;
	
	List<Integer> availableSeats;

	public BusSeatCapacityInfoEntity(List<Integer> bookedSeats, List<Integer> availableSeats) {
		this.bookedSeats = bookedSeats;
		this.availableSeats = availableSeats;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public List<Integer> getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(List<Integer> availableSeats) {
		this.availableSeats = availableSeats;
	}
	

}
