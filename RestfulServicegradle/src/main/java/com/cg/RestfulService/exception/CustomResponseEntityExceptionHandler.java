package com.cg.RestfulService.exception;

import java.util.Date;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
//@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({UserNotFoundException.class})
	public final ResponseEntity handleUserNotFoundException(UserNotFoundException ex,WebRequest req) {
	       System.out.println("Inside ResponseEntityExceptionHandler()");
        ExceptionResponse expResp = new ExceptionResponse(new Date(),ex.getMessage(),"Detail Description of the Exception");
        return new ResponseEntity(expResp,HttpStatus.NOT_FOUND);

    }
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
       
        ExceptionResponse expResp = new ExceptionResponse(new Date(),ex.getMessage(),"Detail Description of the Exception");
        return new ResponseEntity(expResp,HttpStatus.INTERNAL_SERVER_ERROR);
    }

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ExceptionResponse expRes = new ExceptionResponse(new Date(), "Validation Failed",ex.getBindingResult().toString());
//		return new ResponseEntity(expRes, HttpStatus.BAD_REQUEST);
//
//	}
	@Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        System.out.println("Inside handleTypeMismatch()");
        ExceptionResponse expRes = new ExceptionResponse(new Date(), "Validation Failed", ex.getErrorCode());
        return new ResponseEntity<Object>(expRes, HttpStatus.BAD_REQUEST); // 400
    }

}
