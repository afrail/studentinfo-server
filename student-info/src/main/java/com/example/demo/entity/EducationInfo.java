package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String examName;
	
	private String board;
	
	private Integer passingYear;
	
	@ManyToOne
	private StudentInfo studentInfo;
}
