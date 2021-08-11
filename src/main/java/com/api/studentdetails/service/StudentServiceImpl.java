package com.api.studentdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;
import com.api.studentdetails.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	public StudentServiceImpl() {
		
	}

	@Override
	public ModelAndView getAllStudent() {
		ModelAndView mv=new ModelAndView("index");
		List<Student> student=(List<Student>) studentRepository.findAll();
		mv.addObject("student", student);
		return mv;
	}

	@Override
	public ModelAndView addStudent(Student student) {
		ModelAndView mv=new ModelAndView("new_student");
		mv.addObject("student", student);
		return mv;
	}
	
	@Override
	public void student(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public ModelAndView editStudent(int id) {
		ModelAndView mv = new ModelAndView("edit_student");
		Student student=studentRepository.findById(id).orElse(null);
		mv.addObject("student", student);
		return mv;
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
