package com.api.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.studentdetails.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
