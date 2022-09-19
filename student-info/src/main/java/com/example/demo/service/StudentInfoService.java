package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentInfoRequestDto;
import com.example.demo.entity.EducationInfo;
import com.example.demo.entity.StudentInfo;
import com.example.demo.repository.EducationInfoRepository;
import com.example.demo.repository.StudentInfoRepository;

@Service
public class StudentInfoService {

	@Autowired
	private StudentInfoRepository repository;

	@Autowired
	private EducationInfoRepository educationInfoRepository;

	@Transactional
	public StudentInfoRequestDto create(StudentInfoRequestDto dto) {
		StudentInfoRequestDto saveValue = new StudentInfoRequestDto();

		saveValue.setInfo(repository.save(dto.getInfo()));
		List<EducationInfo> educationInfos = dto.getEducation().stream().map(m -> {
			m.setStudentInfo(saveValue.getInfo());
			return m;
		}).collect(Collectors.toList());

		saveValue.setEducation(educationInfoRepository.saveAll(educationInfos));
		return saveValue;
	}

	@Transactional
	public StudentInfoRequestDto update(StudentInfoRequestDto dto) throws Exception {
		if (dto.getInfo() == null || dto.getInfo().getId() == null)
			throw new Exception("info can't be null");

		StudentInfoRequestDto saveValue = new StudentInfoRequestDto();

		saveValue.setInfo(repository.save(dto.getInfo()));

		educationInfoRepository.deleteByStudentInfoId(dto.getInfo().getId());

		List<EducationInfo> educationInfos = dto.getEducation().stream().map(m -> {
			m.setStudentInfo(saveValue.getInfo());
			return m;
		}).collect(Collectors.toList());

		saveValue.setEducation(educationInfoRepository.saveAll(educationInfos));

		return saveValue;
	}

	@Transactional
	public StudentInfoRequestDto getById(Long id) throws Exception {
		if (id == null)
			throw new Exception("id be null");

		StudentInfoRequestDto dto = new StudentInfoRequestDto();

		Optional<StudentInfo> optional = repository.findById(id);
		if (optional.isPresent()) {
			dto.setInfo(optional.get());
			dto.setEducation(educationInfoRepository.findByStudentInfoId(id));
		}
		else
			throw new Exception("data not found");

		return dto;
	}
	
	@Transactional
	public List<StudentInfo> get() throws Exception {
		return repository.findAll();
	}

}
