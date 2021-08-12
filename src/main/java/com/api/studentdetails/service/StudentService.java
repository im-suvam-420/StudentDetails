package com.api.studentdetails.service;

import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;
/*
 * This is Service class which have the declaration
 * of methods for Service Implementation class.
 */
public interface StudentService {

	public ModelAndView getAllStudent();

	public ModelAndView addStudent(Student student);

	public ModelAndView editStudent(int id);
	
	public void deleteStudent(int id);

	public void student(Student student);

}
