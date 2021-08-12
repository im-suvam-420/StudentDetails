package com.api.studentdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Book;
import com.api.studentdetails.exception.BookNotFoundException;
import com.api.studentdetails.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	public BookServiceImpl() {
		
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> book=new ArrayList<>();
		bookRepository.findAll().forEach(book::add);
		return book;
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> book=bookRepository.findById(id);
		if(book.isPresent()) {
			return book.get();
		}else {
			throw new BookNotFoundException("Book Not Found For The Given Id "+ id);
		}
	}

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateStudent(Integer id, Book book) {
		Optional<Book>bookList=bookRepository.findById(id);
		if(bookList.isPresent()) {
			bookRepository.save(book);
		}else {
			throw new BookNotFoundException("Book Not Found For The Given Id "+ id);
		}
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Book>book=bookRepository.findById(id);
		if(book.isPresent()) {
			bookRepository.deleteById(id);
		}else {
			throw new BookNotFoundException("Book Not Found For The Given Id "+ id);
		}
	}
	
}














//@Override
//public ModelAndView getAllBooks() {
//	ModelAndView mv=new ModelAndView("book_index");
//	List<Book> book=(List<Book>) bookRepository.findAll();
//	mv.addObject("book", book);
//	return mv;
//}
//
//@Override
//public ModelAndView addBook(Book book) {
//	ModelAndView mv=new ModelAndView("new_book");
//	mv.addObject("book", book);
//	return mv;
//}
//
//@Override
//public void book(Book book) {
//	bookRepository.save(book);
//	
//}
//
//@Override
//public ModelAndView editBook(Integer id) {
//	ModelAndView mv = new ModelAndView("edit_book");
//	Optional<Book>book=bookRepository.findById(id);
//	if(book.isPresent()) {
//		mv.addObject("book", book);
//		return mv;
//	}else {
//		throw new BookNotFoundException("Can Not Update. Book Not Found For The Given ID "+id);
//	}
//}
//
//@Override
//public void deleteBook(Integer id) {
//	Optional<Book>book=bookRepository.findById(id);
//	if(book.isPresent()) {
//		bookRepository.deleteById(id);
//	}else {
//		throw new BookNotFoundException("This Delete Process is FAILED. Book Not Found For The Given ID "+id);
//	}
//	
//}