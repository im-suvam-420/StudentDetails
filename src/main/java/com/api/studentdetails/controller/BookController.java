package com.api.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.studentdetails.entities.Book;
import com.api.studentdetails.service.BookService;

import io.swagger.models.Model;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/book")
	public List<Book> getAllBook(){
		return bookService.getAllBook();
	}

	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@PostMapping("/book")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@PutMapping("/book{id}")
	public void updateBook(@RequestBody Book book,@PathVariable Integer id) {
		bookService.updateStudent(id,book);
	}

	@DeleteMapping("/book/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		bookService.deleteStudent(id);
	}
}	
	
	
	
	
	
	
	
	

	
	
//	@RequestMapping("/book")
//	public ModelAndView book(Model model) {
//		return bookService.getAllBooks();
//	}
//	
//	@RequestMapping("/newBook")
//	public ModelAndView newFormForBook(Model model) {
//		Book book=new Book();
//		return bookService.addBook(book);
//	}
//	
//	@PostMapping(value = "addBook")
//	public String book(Book book) {
//		bookService.book(book);
//		return "The Ongoing Process Is Done. Please Check The List. Thank You 🙂";
//	}
//	
//	@RequestMapping("/editBook/{id}")
//	public ModelAndView editForm(@PathVariable("id")Integer id) {
//		return bookService.editBook(id);
//	}
//	
//	@RequestMapping("/deleteBook/{id}")
//	public String deleteBook(@PathVariable("id")Integer id) {
//		bookService.deleteBook(id);
//		return "The Book Is Deleted. Thank You!! 😭";
//	}
