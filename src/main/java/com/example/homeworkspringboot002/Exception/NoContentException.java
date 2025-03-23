package com.example.homeworkspringboot002.Exception;

import java.time.LocalDateTime;

public class NoContentException extends RuntimeException {
	private final LocalDateTime timestamp;

	public NoContentException(String message) {
		super(message);
		this.timestamp = LocalDateTime.now();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
