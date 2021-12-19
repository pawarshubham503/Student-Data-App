package com.alosha.responseRest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alosha.responseRest.dao.entities.Student;
import com.alosha.responseRest.service.ResponseRestService;

@RestController
public class ResponseRestController {
 @Autowired
 ResponseRestService responseRestService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> savestudent(@RequestBody Student student) {
	
		long regNo =student.getRegNo();
		Student	persistedStudent=	responseRestService.retrieveStudent(regNo);
		HttpStatus status=HttpStatus.OK;
		if(persistedStudent!=null) {
			System.out.println("update request");
		long persistedId=	persistedStudent.getStudentId();
		student.setStudentId(persistedId);
		persistedStudent =responseRestService.saveStudent(student);
		status=HttpStatus.OK;
		}
		else {
			System.out.println("create req");
			persistedStudent =responseRestService.saveStudent(student);
			status=HttpStatus.CREATED;
		}
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{regNo}").build(persistedStudent.getRegNo());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(location);
		
	ResponseEntity responseEntity=	new ResponseEntity<Student>(persistedStudent, headers, status);
	return responseEntity;
	}
	@GetMapping("/students/{regNo}")
	public ResponseEntity<Student> retrieveStudent(@PathVariable("regNo") long registrationNo) {
		Student	persistedStudent =responseRestService.retrieveStudent(registrationNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(persistedStudent); 
	}
	
	@DeleteMapping("/students/{regNo}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("regNo") long registrationNo) {
		responseRestService.deleteStudent(registrationNo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); 
	}
	
}
