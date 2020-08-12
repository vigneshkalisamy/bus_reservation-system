package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BusOperatorInfoDto;

public interface BusDataAccessRepository extends JpaRepository<BusOperatorInfoDto, Integer>{
	
	public List<BusOperatorInfoDto> finBusOperatorInfoDtos(); 

}
