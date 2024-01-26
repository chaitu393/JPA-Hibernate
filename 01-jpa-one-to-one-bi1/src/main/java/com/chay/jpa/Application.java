package com.chay.jpa;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chay.jpa.dao.AppDao;
import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao)
	{
		
		return runner->
		{
//			createInstructor(appDao);
//			findInstructorById(appDao);
//		    deleteInstructorById(appDao);
//			findInstructorDetail(appDao);
			deleteInstructorDetailById(appDao);
		};
		
	}
	private void deleteInstructorDetailById(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Deleting:");
		int theId=scan.nextInt();
		
		appDao.deleteInstructorDetailById(theId);
		 
		System.out.println("Done...!");
		
	}
	private void findInstructorDetail(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Retrieving:");
		int theId=scan.nextInt();
		
		InstructorDetail tempDetail=appDao.findInstructorDetailById(theId);
		
		System.out.println("Instructor Detail:"+tempDetail);
		
		System.out.println("Associate Instructor:"+tempDetail.getInstructor());
	
		
	}
	private void deleteInstructorById(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Deleting:");
		int theId=scan.nextInt();
		
		appDao.deleteById(theId);
		
		System.out.println("Deleted the Instructor....!!!");
		
		
	}
	private void findInstructorById(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id:");
		int theId=scan.nextInt();
		
		System.out.println("Finding the Instructor By Id:"+theId);
		
		Instructor tempInstructor=appDao.findInstructorById(theId);
		
		System.out.println("Instructor Data:"+tempInstructor);
		
		System.out.println("Associated Instructor:"+tempInstructor.getInstructorDetail());
		
	}
	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("chaitanya","chikkam","chaituchaiii9933@gmail.com");
//		Instructor tempInstructor=new Instructor("Kiran","chikkam","kiranchaitanya393@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"http://www.chaituchaiii.com/youtube", 
				"Music");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		System.out.println("Saving Instructor:"+tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done....!");
	}

}
