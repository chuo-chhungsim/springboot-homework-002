package com.example.homeworkspringboot002.Model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteResponse<T> {
	private String message;
	private T payload;
	private HttpStatus status;
	private LocalDateTime time;
}
