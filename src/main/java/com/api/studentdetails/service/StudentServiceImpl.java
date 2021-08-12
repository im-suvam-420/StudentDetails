package com.api.studentdetails.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;
import com.api.studentdetails.exception.StudentNotFoundException;
import com.api.studentdetails.repository.StudentRepository;
/*
 * This is Service Implementation class which contains 
 * logic to get all Product Documents,
 * Product Documents by Id, updating, creating and deleting.
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	//Declaration
	@Autowired
	StudentRepository studentRepository;
	
	public StudentServiceImpl() {
		
	}

	
	/**
	 * This method is for retrieving All Student Details Record 
	 */
	@Override
	public ModelAndView getAllStudent() {
		ModelAndView mv=new ModelAndView("index");
		List<Student> student=(List<Student>) studentRepository.findAll();
		mv.addObject("student", student);
		return mv;
	}

	/**
	 * This Method is for crating new Student Details Record
	 */
	@Override
	public ModelAndView addStudent(Student student) {
		ModelAndView mv=new ModelAndView("new_student");
		mv.addObject("student", student);
		return mv;
	}
	
	/**
	 * This method is  for both creating and updating one student details
	 */
	@Override
	public void student(Student student) {
		studentRepository.save(student);
		
	}

	/**
	 * This method is for editing One Student Details
	 */
	@Override
	public ModelAndView editStudent(int id) {
		ModelAndView mv = new ModelAndView("edit_student");
		Optional<Student>student=studentRepository.findById(id);
		if(student.isPresent()) {
			mv.addObject("student", student);
			return mv;
		}else {
			throw new StudentNotFoundException("Can Not Update. Student Not Found For The Given ID "+id);
		}

	}

	/**
	 * This method is for deleting One Student Details Record.
	 */
	@Override
	public void deleteStudent(int id) {
		Optional<Student>student=studentRepository.findById(id);
		if(student.isPresent()) {
		studentRepository.deleteById(id);
		}else {
			throw new StudentNotFoundException("This Delete Process is FAILED. Student Not Found For The Given ID "+id);
		}
	}

}
