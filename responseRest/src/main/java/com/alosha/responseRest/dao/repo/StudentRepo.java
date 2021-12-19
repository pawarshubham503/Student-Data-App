package com.alosha.responseRest.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alosha.responseRest.dao.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	
	public Student findByRegNo(long regNo);
}
