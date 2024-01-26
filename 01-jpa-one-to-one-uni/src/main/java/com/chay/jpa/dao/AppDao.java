package com.chay.jpa.dao;

import com.chay.jpa.entity.Instructor;

public interface AppDao 
{

	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteById(int theId);
}
