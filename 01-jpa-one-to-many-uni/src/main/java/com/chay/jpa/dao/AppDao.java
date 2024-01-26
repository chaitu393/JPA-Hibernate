package com.chay.jpa.dao;

import java.util.List;

import com.chay.jpa.entity.Course;
import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;

public interface AppDao 
{

	void save(Instructor theInstructor);
	Instructor findInstructorById(int theId);
	void deleteById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCourseByInstructorId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void update(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteInstructorById(int theId);
	
	void deleteCourseById(int theId);
}
