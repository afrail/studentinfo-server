package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EducationInfo;

public interface EducationInfoRepository extends JpaRepository<EducationInfo, Long> {
	void deleteByStudentInfoId(Long id);
	
	List<EducationInfo> findByStudentInfoId(Long id);
}
