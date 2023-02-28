package com.riskmanagement.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "risks")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Risks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 20)
	private String status;

	@Column(columnDefinition = "TEXT")
	private String subject;

	@Column(length = 20)
	private String reference_id;

	private long regulation;

	@Column(length = 20)
	private String control_number;

	private long source;

	private long category;

	private long owner;

	private long manager;

	@Column(columnDefinition = "TEXT")
	private String assessment;

	@Column(columnDefinition = "TEXT")
	private String notes;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date subbmission_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date last_update;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
