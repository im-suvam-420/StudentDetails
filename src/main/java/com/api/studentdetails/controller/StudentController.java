package com.api.studentdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;
import com.api.studentdetails.service.StudentService;

import io.swagger.models.Model;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student")
	public ModelAndView student(Model model) {
		return studentService.getAllStudent();
	}
	
	@RequestMapping("/new")
	public ModelAndView newFormForStudent(Model model) {
		Student student=new Student();
		return studentService.addStudent(student);
	}
	
	@PostMapping(value = "add")
	public String student(Student student) {
		studentService.student(student);
		return "The Ongoing Process Is Done. Please Check The List. Thank You :)";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editForm(@PathVariable("id")int id) {
		return studentService.editStudent(id);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id")int id) {
		studentService.deleteStudent(id);
		return "The Student Is Deleted. Thank You!!";
	}
}
