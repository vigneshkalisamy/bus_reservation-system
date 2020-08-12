package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BusDataAccessRepository;
import com.example.demo.dao.SeatBookingRepository;
import com.example.demo.entity.BusSearchParamEntity;
import com.example.demo.entity.BusSearchResult;
import com.example.demo.entity.BusSeatCapacityInfoEntity;
import com.example.demo.model.BusOperatorInfoDto;
import com.example.demo.model.BusSeatingArrangement;
import com.example.demo.model.SeatBookingInfoDto;

@RestController
@RequestMapping("/userAgentControl")
public class BusAgentController {
	
	@Autowired
	BusDataAccessRepository busDataAccess;
	
	@Autowired
	SeatBookingRepository bookingAccess;
	
	
	@GetMapping("/searchBusList")
	public ResponseEntity fetchBusSearchResult(@RequestBody BusSearchParamEntity busSearchParamEntity){
		List<BusOperatorInfoDto> busInfoList = busDataAccess.finBusOperatorInfoDtos();
		List<BusOperatorInfoDto> sourceToDestinationTravelList = busInfoList.stream().filter(filter ->{
			return (filter.getSourceCity().equals(busSearchParamEntity.getSourceCity()) && 
			filter.getDestinationCity().equals(busSearchParamEntity.getDestinationCity()) &&
			filter.getTravelDate().equals(busSearchParamEntity.getTravelDate()));
		}).collect(Collectors.toList());
		
		List<BusOperatorInfoDto> destinationtoSourceTravelList = busInfoList.stream().filter(filter ->{
			return (filter.getSourceCity().equals(busSearchParamEntity.getDestinationCity()) && 
			filter.getDestinationCity().equals(busSearchParamEntity.getSourceCity()) &&
			filter.getTravelDate().equals(busSearchParamEntity.getReturnTravelDate()));
		}).collect(Collectors.toList());
		sourceToDestinationTravelList.addAll(destinationtoSourceTravelList);
		List<BusOperatorInfoDto> sortedList = sourceToDestinationTravelList.stream().sorted(Comparator.comparing(BusOperatorInfoDto::getPrice)).collect(Collectors.toList());
		return new ResponseEntity(new BusSearchResult(sortedList, sortedList.size()), HttpStatus.OK);
	}
	
	@PostMapping("/confirmBooking")
	public String insertBookingInformation(@RequestBody SeatBookingInfoDto seat) {
		Random rd = new Random();
		int bookingOperatorCode = seat.getOperatorCode();
		BusOperatorInfoDto operatorInfo = busDataAccess.findById(bookingOperatorCode).get();
		int busFullCapacity = operatorInfo.getBusSeatingCapacity();
		List<Integer> occupiedSeatsList = operatorInfo.getOccupiedPassengers().stream().map(BusSeatingArrangement::getSeatNumber).collect(Collectors.toList());
		List<Integer> fullCapacityList = IntStream.rangeClosed(1, busFullCapacity).boxed().collect(Collectors.toList());
		fullCapacityList.removeAll(occupiedSeatsList);
		
		Integer randomSeat = fullCapacityList.get(rd.nextInt(fullCapacityList.size()));
		if(seat.getSelectedSeat() !=0) {
			seat.setBookingAmount(seat.getBookingAmount() + (seat.getBookingAmount()/10));
		} else {
			seat.setSelectedSeat(randomSeat);
		}
		
		long bookingId = rd.nextLong();
		seat.setBookingId(bookingId);
		bookingAccess.save(seat);
		
		return "Booking confirmed: "+ bookingId;
	}
	
	@GetMapping("/bookedAndAvailableSeats")
	public BusSeatCapacityInfoEntity fetchBusSearchResult(@RequestParam int operatorCode){
		BusOperatorInfoDto operatorInfo = busDataAccess.findById(operatorCode).get();
		List<Integer> occupiedSeatsList = operatorInfo.getOccupiedPassengers().stream().map(BusSeatingArrangement::getSeatNumber).collect(Collectors.toList());
		int busFullCapacity = operatorInfo.getBusSeatingCapacity();
		List<Integer> fullCapacityList = IntStream.rangeClosed(1, busFullCapacity).boxed().collect(Collectors.toList());
		fullCapacityList.removeAll(occupiedSeatsList);
		return new BusSeatCapacityInfoEntity(occupiedSeatsList, fullCapacityList);
		
	}
	

}
