package com.api.studentdetails.errortype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorType {

	private String messsge;
	private String code;
	private String error;
	private String classType;
	
}
