package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentInfoRequestDto;
import com.example.demo.entity.StudentInfo;
import com.example.demo.service.StudentInfoService;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentInfoController {

	@Autowired
	private StudentInfoService service;

	@PostMapping
	public ResponseEntity<StudentInfoRequestDto> create(@RequestBody StudentInfoRequestDto dto) {
		try {
			return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity<StudentInfoRequestDto> update(@RequestBody StudentInfoRequestDto dto) {
		try {
			return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentInfoRequestDto> getById(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<StudentInfo>> get() {
		try {
			return new ResponseEntity<>(service.get(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
