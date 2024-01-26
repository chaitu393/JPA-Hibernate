package com.chay.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;
  
  @Column(name="youtube_channel")
  private String youTubeChannel;
  
  @Column(name="hobby")
  private String hobby;
  
  @OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
  private Instructor instructor;
  
  
  public Instructor getInstructor() {
	return instructor;
}

public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

public InstructorDetail()
  {
	  
  }

  public InstructorDetail(String youTubeChannel, String hobby) {
	
	this.youTubeChannel = youTubeChannel;
	this.hobby = hobby;
  }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getYouTubeChannel() {
	return youTubeChannel;
}

public void setYouTubeChannel(String youTubeChannel) {
	this.youTubeChannel = youTubeChannel;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
	return "InstructorDetail [id=" + id + ", "
			+ ""+ "youTubeChannel=" + youTubeChannel + ", "
					+ "hobby=" + hobby + "]";
}
  
}
