package com.riskmanagement.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RisksDto {
	
	
	private String status;

	
	private String subject;

	
	private String reference_id;

	private long regulation;

	
	private String control_number;

	private long source;

	private long category;

	private long owner;

	private long manager;

	
	private String assessment;

	
	private String notes;

	
	private Date subbmission_date;
	
	private Date last_update;
	
	private Date review_date;

	private Long mitigation_id;

	private long mgmt_id;

	private long project_id;

	private long close_id;

	private long subbmited_by;

	private String risk_catalog_mapping;

	private String threat_catalog_mapping;

	private long template_group_id;

}
