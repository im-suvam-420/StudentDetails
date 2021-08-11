package com.api.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.studentdetails.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}
