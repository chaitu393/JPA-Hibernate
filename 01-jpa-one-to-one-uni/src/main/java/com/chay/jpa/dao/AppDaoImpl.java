package com.chay.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chay.jpa.entity.Instructor;

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

}
