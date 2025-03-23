package com.example.homeworkspringboot002.Exception;

import java.time.LocalDateTime;

public class NotFoundException extends RuntimeException {
	private final LocalDateTime timestamp;

	public NotFoundException(String message) {
		super(message);
		this.timestamp = LocalDateTime.now();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}