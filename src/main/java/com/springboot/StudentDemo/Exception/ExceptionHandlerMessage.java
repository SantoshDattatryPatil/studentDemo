package com.springboot.StudentDemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class ExceptionHandlerMessage {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidation(MethodArgumentNotValidException exception){
    ErrorDetails errorDetails= new ErrorDetails(new Date(),"Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
    return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
}
}
