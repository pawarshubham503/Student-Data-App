package com.alosha.responseRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alosha.responseRest.dao.entities.Student;
import com.alosha.responseRest.dao.repo.StudentRepo;

@Service
public class ResponseRestService {

	
	@Autowired
	StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	
	public Student retrieveStudent(long regNo) {
		return	studentRepo.findByRegNo(regNo);
	}
	
	
	public void deleteStudent(long regNo) {
		
		
		Student persistedStudent=	studentRepo.findByRegNo(regNo);
          if(persistedStudent!=null) { 
        	  studentRepo.delete(persistedStudent);
          }
	}
	
	
}
