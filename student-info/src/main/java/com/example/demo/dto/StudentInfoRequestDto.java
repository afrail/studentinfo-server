package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.EducationInfo;
import com.example.demo.entity.StudentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoRequestDto {

	private StudentInfo info;

	private List<EducationInfo> education;
}
