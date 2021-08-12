package com.api.studentdetails.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Book;

public interface BookService {

	public List<Book> getAllBook();

	public Book getBookById(Integer id);

	public void addBook(Book book);

	public void updateStudent(Integer id, Book book);

	public void deleteStudent(Integer id);


}






//public ModelAndView getAllBooks();
//
//public ModelAndView addBook(Book book);
//
//public void book(Book book);
//
//public ModelAndView editBook(Integer id);
//
//public void deleteBook(Integer id);
