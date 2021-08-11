package com.api.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Student;
import com.api.studentdetails.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/student")
	public ModelAndView student(Model model){
		ModelAndView mv=new ModelAndView("index");
		List<Student> student=(List<Student>) studentRepository.findAll();
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping("/new")
	public ModelAndView newformforstudent(Model model){
		ModelAndView mv=new ModelAndView("new_student");
		Student student=new Student();
		studentRepository.save(student);
		mv.addObject("student", student);
		return mv;
	}

	@PostMapping(value="add")
	public String addstudent(Student student){
		studentRepository.save(student);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editform(@PathVariable("id")int id){
		ModelAndView mv=new ModelAndView("edit_student");
		Student student= studentRepository.findById(id).orElse(null);
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id")int id){
		studentRepository.deleteById(id);
		return "redirect:/";
	}
}
