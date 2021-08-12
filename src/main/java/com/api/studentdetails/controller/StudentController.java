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

/**
 * This is a controller class which will handle all API requests sent to it.
 *
 */
@RestController
public class StudentController {

	//Declaration
	@Autowired
	StudentService studentService;

	/**
	 * This method is for retrieving 
	 * All Student Details Record 
	 * 
	 * @param model
	 * @return All Student Details
	 */
	@RequestMapping("/student")
	public ModelAndView student(Model model) {
		return studentService.getAllStudent();
	}

	/**
	 * This Method is for crating new Student Details Record
	 * 
	 * @param model
	 * @return Student Details
	 */
	@RequestMapping("/new")
	public ModelAndView newFormForStudent(Model model) {
		Student student=new Student();
		return studentService.addStudent(student);
	}

	/**
	 * This method is  for both creating and
	 * updating one student details
	 * 
	 * @param student
	 * @return Response for the ongoing process.
	 */
	@PostMapping(value = "add")
	public String student(Student student) {
		studentService.student(student);
		return "The Ongoing Process Is Done. Please Check The List. Thank You 🙂";
	}

	/**
	 * This method is for editing One Student Details
	 * 
	 * @param id
	 * @return Student Details for the given Id
	 */
	@RequestMapping("/edit/{id}")
	public ModelAndView editForm(@PathVariable("id")int id) {
		return studentService.editStudent(id);
	}

	/**
	 * This method is for deleting One Student Details Record.
	 * 
	 * @param id
	 * @return Response For The Ongoing Process
	 */
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id")int id) {
		studentService.deleteStudent(id);
		return "The Student Is Deleted. Thank You!! 😭";
	}
}
