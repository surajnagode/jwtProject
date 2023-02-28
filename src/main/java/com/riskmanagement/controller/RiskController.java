package com.riskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.riskmanagement.payloads.RisksDto;
import com.riskmanagement.service.RiskService;


@RestController
@RequestMapping("/rmf/risks")
public class RiskController {

	
	
	@Autowired
	private RiskService riskService;

	@PostMapping("/new")
	public ResponseEntity<RisksDto> createRisk(@RequestBody RisksDto risksDto) {
		RisksDto createRisk = this.riskService.createRisk(risksDto);
		return new ResponseEntity<RisksDto>(createRisk, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<RisksDto>> getAllRisks() {

		List<RisksDto> risks = this.riskService.getAllRisks();
		return ResponseEntity.ok(risks);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RisksDto> getRiskById(@PathVariable("id") long riskId){
		
	    RisksDto risksDto = this.riskService.getRiskById(riskId);
	    return new ResponseEntity<RisksDto>(risksDto,HttpStatus.OK);
		
	}
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<RisksDto> updateRisk(@RequestBody RisksDto risksDto, @PathVariable("id") long uid){
	    	RisksDto updateRisk = this.riskService.updateRisk(risksDto, uid);
	    	return new ResponseEntity<RisksDto>(updateRisk,HttpStatus.OK);
	    }
		
    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteRisk(@PathVariable("id") long id){
	    	this.riskService.deleteRisk(id);
	    	return new ResponseEntity<String>("Risk is Deleted Successfully",HttpStatus.OK);
	    }

}
