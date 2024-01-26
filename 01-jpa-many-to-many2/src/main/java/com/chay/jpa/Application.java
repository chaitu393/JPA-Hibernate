package com.chay.jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chay.jpa.dao.AppDao;
import com.chay.jpa.entity.Course;
import com.chay.jpa.entity.Instructor;
import com.chay.jpa.entity.InstructorDetail;
import com.chay.jpa.entity.Review;
import com.chay.jpa.entity.Student;

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
			
//			CreateCourseAndStudent(appDao);
//			findCourseAndStudent(appDao);
//			findStudentAndCourses(appDao);
//			addMoreCourses(appDao);
//			deleteCourse(appDao);
			deleteStudent(appDao);
		};
		
	}
	private void deleteStudent(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Delete:");
		int theId=scan.nextInt();
		appDao.deleteStudentById(theId);
		System.out.println("Deletion Done...!");
		
		
	}
	private void addMoreCourses(AppDao appDao) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id");
		int theId=scan.nextInt();
		
		Student tempStudent=appDao.findCourseAndStudentsByStudentId(theId);
		
		Course t1=new Course("java");
		Course t2=new Course("react");
		
		tempStudent.addCourse(t1);
		tempStudent.addCourse(t2);
		
		appDao.update(tempStudent);
		
		System.out.println("Updated Courses&Students:"+tempStudent);
		System.out.println("Associated Course:"+tempStudent.getCourses());
		
		System.out.println("Done..!");
		
		
	}
	private void findStudentAndCourses(AppDao appDao) {
		// TODO Auto-generated method stub
        int theId=2;
		
		Student tempStudent=appDao.findCourseAndStudentsByStudentId(theId);
		
		System.out.println("Retriving Data:"+tempStudent);
		
		System.out.println("Associated Students:"+tempStudent.getCourses());
		
		System.out.println("Done...!");
		
	}
	private void findCourseAndStudent(AppDao appDao)
	{
		int theId=10;
		
		Course tempCourse=appDao.findCourseAndStudentsByCourseId(theId);
		
		System.out.println("Retriving Data:"+tempCourse);
		
		System.out.println("Associated Students:"+tempCourse.getStudents());
		
		System.out.println("Done...!");
		
	}
	private void CreateCourseAndStudent(AppDao appDao) {
Course tempCourse=new Course("DesignAndManfacturing");
		
		Student tempStudent1=new Student("chaitanya","chikkam","chaituchaiii9933@gmail.com");
		Student tempStudent2=new Student("sivaprasad","konda","sivaprasad412@gmail.com");
		
		
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		System.out.println("saving the Course:");
		
		System.out.println("Courses:"+tempCourse);
		
		System.out.println("Associated Students:"+tempCourse.getStudents());
		
		appDao.save(tempCourse);
		
		System.out.println("Done...!");
		
	}
	private void deleteCourseAndReviews(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Delete:");
		int theId=scan.nextInt();
		
		System.out.println("Deleting Id:"+theId);
		
		appDao.deleteCourseById(theId);
		
		System.out.println("Deletion Done...!");
		
		
		
	}
	private void reciveCourseAndReviews(AppDao appDao) {
		// TODO Auto-generated method stub
		int theId=10;
		
		Course tempCourse=appDao.findCourseAndReviewsById(theId);
		
		System.out.println(tempCourse);
		
		System.out.println(tempCourse.getReviews());
		
		System.out.println("Done...!");
		
		
	}
	private void createCourseAndReviews(AppDao appDao) {
		// TODO Auto-generated method stub
		
		Course tempCourse=new Course("Full Stack Java");
		
		tempCourse.add(new Review("Difficult but its Great...!"));
		tempCourse.add(new Review("Good oppurtunities...!"));
		tempCourse.add(new Review("Difficult to understand...!"));
		
		System.out.println("Saving the course...");
		
		System.out.println(tempCourse.getReviews());
		
		appDao.save(tempCourse);
		
		System.out.println("Done...!");
		
	}
	private void deleteCourse(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Course Id For deleting:");
		int theId=scan.nextInt();
		
		appDao.deleteCourseById(theId);
		
		System.out.println("Done...!");
		
		
	}
	private void deleteInstructor(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For deleting:");
		int theId=scan.nextInt();
		
		appDao.deleteInstructorById(theId);
		
		System.out.println("Done...!");
		
		
		
	}
	private void updateCourse(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Updating:");
		int theId=scan.nextInt();
		
		System.out.println("Finding Course:"+theId);
		
		Course tempCourse=appDao.findCourseById(theId);
		System.out.println("Enter The title for update...");
		
		String title=scan.next();
		
	
		
	    tempCourse.setTitle(title);
		
		appDao.update(tempCourse);
		
		System.out.println("Done..!");
		
	}
	private void updateInstructor(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Updating:");
		int theId=scan.nextInt();
		
		System.out.println("Finding Instructor:"+theId);
		
		Instructor tempInstructor=appDao.findInstructorById(theId);
		
		tempInstructor.setFirstName("kiran");
		
		appDao.update(tempInstructor);
		
		System.out.println("Done..!");
		
		
		
		
	}
	private void findInstructorWithCourseJoinFetch(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Retrieving:");
		int theId=scan.nextInt();
		
		System.out.println("Find Instructor With Id:"+theId);
		Instructor tempInstructor=appDao.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		System.out.println("Associated Instructor :"+tempInstructor.getCourses());
		System.out.println("Done..!");
		
		
	}
	private void findCoursesForInstructor(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Retrieving:");
		int theId=scan.nextInt();
		
		Instructor tempInstructor=appDao.findInstructorById(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		
		List<Course> courses=appDao.findCourseByInstructorId(theId);
		
		tempInstructor.setCourses(courses);
		
		System.out.println("Associate Courses:"+tempInstructor.getCourses());
		
		System.out.println("Done...!");
		
	}
	private void findInstructorWithCourses(AppDao appDao) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id For Retrieving:");
		int theId=scan.nextInt();
		
		System.out.println("Find Instructor With Id:"+theId);
		Instructor tempInstructor=appDao.findInstructorById(theId);
		System.out.println("tempInstructor:"+tempInstructor);
		System.out.println("Associated Instructor :"+tempInstructor.getCourses());
		System.out.println("Done..!");
		
		
	}
	private void createInstructorWithCourse(AppDao appDao) {
		// TODO Auto-generated method stub
		Instructor tempInstructor=new Instructor("chaitanya","chikkam","chaituchaiii9933@gmail.com");
//		Instructor tempInstructor=new Instructor("Kiran","chikkam","kiranchaitanya393@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"http://www.chaituchaiii.com/youtube", 
				"Music");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1=new Course("Full Stack java Developement");
		Course tempCourse2=new Course("React Js");
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		System.out.println("Instructor saving:"+tempInstructor);
		
		System.out.println("Couses:"+tempInstructor.getCourses());
		
		appDao.save(tempInstructor);
		
		System.out.println("Done...!");
		
		
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
