package com.api.studentdetails.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.studentdetails.errortype.ErrorType;
import com.api.studentdetails.exception.StudentNotFoundException;

/**
 * This Is A Handler Class Which Will Perform All the Exception Handling
 *
 */
@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorType>showError(RuntimeException e){
		return new ResponseEntity<ErrorType>(new ErrorType(e.getMessage(),
				"NO_STUDENT_FOUND",
				"DATA NOT FOUND FOR THE GIVEN ID",
				"Student"),HttpStatus.NOT_FOUND);
	}
}
