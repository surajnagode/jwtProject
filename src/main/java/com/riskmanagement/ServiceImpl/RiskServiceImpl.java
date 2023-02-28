package com.riskmanagement.ServiceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskmanagement.entites.Risks;
import com.riskmanagement.exceptions.ResourceNotFoundException;
import com.riskmanagement.payloads.RisksDto;
import com.riskmanagement.repository.RiskRepository;
import com.riskmanagement.service.RiskService;

@Service
public class RiskServiceImpl implements RiskService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RiskRepository riskRepository;

	@Override
	public RisksDto createRisk(RisksDto risksDto) {
		Risks risks = this.modelMapper.map(risksDto, Risks.class);
		

		 Risks addedRisk = this.riskRepository.save(risks);
		 return this.modelMapper.map(addedRisk, RisksDto.class);
	}

	@Override
	public List<RisksDto> getAllRisks() {

		List<Risks> risks = this.riskRepository.findAll();
		List<RisksDto> list = risks.stream().map((risk)-> this.modelMapper.map(risk, RisksDto.class)).collect(Collectors.toList());
		return list;
		
	}

	@Override
	public RisksDto getRiskById(long id) {

		
		/*
		 * Optional<Risks> risk = this.riskRepository.findById(id);
		 * 
		 * if(risk.isPresent()) { return risk.get(); }else { throw new
		 * ResourceNotFoundException("Risks", "id", id); }
		 */

		Risks risks = this.riskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Risks", "Id", id));
		return this.modelMapper.map(risks, RisksDto.class);

	}

	@Override
	public RisksDto updateRisk(RisksDto risksDto, long id) {

		Risks existingRisk = this.riskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Risks", "Id", id));

		existingRisk.setStatus(risksDto.getStatus());
		existingRisk.setSubject(risksDto.getSubject());
		existingRisk.setReference_id(risksDto.getReference_id());
		existingRisk.setRegulation(risksDto.getRegulation());
		existingRisk.setControl_number(risksDto.getControl_number());
		existingRisk.setSource(risksDto.getSource());

		existingRisk.setCategory(risksDto.getCategory());
		existingRisk.setOwner(risksDto.getOwner());
		existingRisk.setManager(risksDto.getManager());
		existingRisk.setAssessment(risksDto.getAssessment());
		existingRisk.setSubbmission_date(risksDto.getSubbmission_date());
		existingRisk.setLast_update(risksDto.getLast_update());

		existingRisk.setReview_date(risksDto.getReview_date());
		existingRisk.setMitigation_id(risksDto.getMitigation_id());
		existingRisk.setMgmt_id(risksDto.getMgmt_id());
		existingRisk.setProject_id(risksDto.getProject_id());
		existingRisk.setClose_id(risksDto.getClose_id());
		existingRisk.setSubbmited_by(risksDto.getSubbmited_by());

		existingRisk.setRisk_catalog_mapping(risksDto.getRisk_catalog_mapping());
		existingRisk.setThreat_catalog_mapping(risksDto.getThreat_catalog_mapping());
		existingRisk.setTemplate_group_id(risksDto.getTemplate_group_id());
		existingRisk.setNotes(risksDto.getNotes());

		Risks saveRisk = this.riskRepository.save(existingRisk);

		return this.modelMapper.map(saveRisk, RisksDto.class);
	}

	@Override
	public void deleteRisk(long id) {

		Risks risks = this.riskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Risks", "Id", id));
		this.riskRepository.delete(risks);

	}

}
