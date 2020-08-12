package com.example.demo.entity;

import java.util.List;

import com.example.demo.model.BusOperatorInfoDto;

public class BusSearchResult {
	
	private List<BusOperatorInfoDto> totalSearchResult;
	
	private int totalNumberOfResults;
	
	public List<BusOperatorInfoDto> getTotalSearchResult() {
		return totalSearchResult;
	}

	public void setTotalSearchResult(List<BusOperatorInfoDto> totalSearchResult) {
		this.totalSearchResult = totalSearchResult;
	}

	public int getTotalNumberOfResults() {
		return totalNumberOfResults;
	}

	public void setTotalNumberOfResults(int totalNumberOfResults) {
		this.totalNumberOfResults = totalNumberOfResults;
	}

	public BusSearchResult(List<BusOperatorInfoDto> totalSearchResult, int totalNumberOfResults) {
		super();
		this.totalSearchResult = totalSearchResult;
		this.totalNumberOfResults = totalNumberOfResults;
	}


}
