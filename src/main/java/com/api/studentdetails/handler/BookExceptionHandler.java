package com.api.studentdetails.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.studentdetails.errortype.ErrorType;
import com.api.studentdetails.exception.BookNotFoundException;
@RestControllerAdvice
public class BookExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorType>showError(RuntimeException e){
		return new ResponseEntity<ErrorType>(new ErrorType(e.getMessage(),
				"NO_BOOK_FOUND",
				"DATA NOT FOUND FOR THE GIVEN ID",
				"Book"),HttpStatus.NOT_FOUND);
	}
}
