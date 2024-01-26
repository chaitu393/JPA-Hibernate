package com.chay.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chay.jpa.entity.Course;
import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao
{
	
	private EntityManager entityManager;
	@Autowired
	public AppDaoImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) 
	{
		entityManager.persist(theInstructor);
		
	}

	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		Instructor tempInst=entityManager.find(Instructor.class, theId);
		entityManager.remove(tempInst);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		
		
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		
		InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class, theId);
		
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(tempInstructorDetail);		
	}

	@Override
	public List<Course> findCourseByInstructorId(int theId) {
		TypedQuery<Course> query=entityManager.createQuery(
				"from Course where instructor.id=:data"
				, Course.class);
		query.setParameter("data",theId);
		List<Course> courses=query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		TypedQuery<Instructor> query=entityManager.createQuery(
			"select i from Instructor i "
		   + "JOIN FETCH i.courses "
		   + "JOIN FETCH i.instructorDetail "
		   + "where i.id=:data", Instructor.class);
		query.setParameter("data",theId);
		Instructor instructor=query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		// TODO Auto-generated method stub
		entityManager.merge(tempInstructor);
		
	}

	@Override
	@Transactional
	public void update(Course tempCourse) {
		// TODO Auto-generated method stub
		entityManager.merge(tempCourse);
		
	}

	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		Instructor tempInstructor=entityManager.find(Instructor.class,theId);
		
		List<Course> courses=tempInstructor.getCourses();
		
		
		for (Course tempcourse : courses) {
			tempcourse.setInstructor(null);
		}
		entityManager.remove(tempInstructor);
		
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		
		Course tempCourse=entityManager.find(Course.class,theId);
		entityManager.remove(tempCourse);
		
	}

}
