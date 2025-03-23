package com.example.homeworkspringboot002.Model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

	@NotNull(message = "Student name is required")
	@NotBlank(message = "Student name cannot be empty")
	private String studentName;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be empty")
	private String email;

	@NotBlank(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be between 8-15 digits")
	private String phoneNumber;

	@NotNull(message = "Course ID list cannot be null")
	@Size(min = 1, message = "At least one course ID is required")
	private List<Long> courseId;
}
