package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SeatBookingInfoDto {
	
	@Id @GeneratedValue
	private int id;
	
	private Long bookingId;
	
	private int operatorCode;
	
	private String operatorName;
	
	private int selectedSeat;
	
	private int bookingAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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

	public int getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(int bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
	
	public int getSelectedSeat() {
		return selectedSeat;
	}

	public void setSelectedSeat(int selectedSeat) {
		this.selectedSeat = selectedSeat;
	}
	

}
