package com.api.studentdetails.service;

import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;

public interface StudentService {

	public ModelAndView getAllStudent();

	public ModelAndView addStudent(Student student);

	public ModelAndView editStudent(int id);
	
	public void deleteStudent(int id);

	public void student(Student student);


}
