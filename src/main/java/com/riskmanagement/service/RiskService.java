package com.riskmanagement.service;

import java.util.List;

import com.riskmanagement.payloads.RisksDto;



public interface RiskService {

	public RisksDto createRisk(RisksDto risksDto);

	public RisksDto updateRisk(RisksDto risks, long id);

	public RisksDto getRiskById(long id);

	public List<RisksDto> getAllRisks();
	
	void deleteRisk(long id);
	

}
