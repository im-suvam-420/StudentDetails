package com.api.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.studentdetails.entities.Student;

/*
 * This is Repository class which have JpaRepository 
 * which will allow CRUD operation in Database.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
