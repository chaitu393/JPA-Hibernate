package com.chay.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
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

}
