package com.example.homeworkspringboot002.Exception;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;


import org.springframework.http.ProblemDetail;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Handle validation errors from @Valid annotations
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidationException(MethodArgumentNotValidException ex) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle("Validation Failed");

		// Collect field validation errors
		Map<String, String> errors = new HashMap<>();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		// Add errors to ProblemDetail
		problemDetail.setProperty("errors", errors);
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;
	}

	// Handle validation errors from method parameters
	@ExceptionHandler(HandlerMethodValidationException.class)
	public ProblemDetail handleMethodValidationException(HandlerMethodValidationException e) {
		Map<String, String> errors = new HashMap<>();

		// Process parameter validation errors
		e.getParameterValidationResults().forEach(parameterError -> {
			String paramName = parameterError.getMethodParameter().getParameterName();
			for (var messageError : parameterError.getResolvableErrors()) {
				errors.put(paramName, messageError.getDefaultMessage());
			}
		});

		// Create ProblemDetail response
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle("Method Parameter Validation Failed");
		problemDetail.setProperties(Map.of(
				"timestamp", LocalDateTime.now(),
				"errors", errors
		));

		return problemDetail;
	}

	// Handle resource not found exceptions
	@ExceptionHandler(NotFoundException.class)
	public ProblemDetail handleNotFoundException(NotFoundException ex) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Resource Not Found");
		problemDetail.setDetail(ex.getMessage());
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;
	}
}
