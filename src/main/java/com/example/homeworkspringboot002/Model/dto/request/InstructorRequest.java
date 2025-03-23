package com.example.homeworkspringboot002.Model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {

	@NotNull(message = "Instructor name is required")
	@NotBlank(message = "Instructor name cannot be empty")
	private String instructorName;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be empty")
	private String email;
}
