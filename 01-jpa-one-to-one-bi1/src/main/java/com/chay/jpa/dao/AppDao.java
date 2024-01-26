package com.chay.jpa.dao;

import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;

public interface AppDao 
{

	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	void deleteInstructorDetailById(int theId);
}
