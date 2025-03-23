package com.example.homeworkspringboot002.Model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

	@NotNull(message = "Course name is required")
	@NotBlank(message = "Course name cannot be empty")
	private String courseName;

	@NotNull(message = "Description is required")
	@NotBlank(message = "Description cannot be empty")
	private String description;

	@NotNull(message = "Instructor ID is required")
	private Long instructorId;
}
