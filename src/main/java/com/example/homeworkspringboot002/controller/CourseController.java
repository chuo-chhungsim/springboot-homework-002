package com.example.homeworkspringboot002.controller;

import com.example.homeworkspringboot002.Model.Entity.Course;
import com.example.homeworkspringboot002.Model.dto.request.CourseRequest;
import com.example.homeworkspringboot002.Model.dto.response.ApiResponse;
import com.example.homeworkspringboot002.Model.dto.response.DeleteResponse;
import com.example.homeworkspringboot002.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@Validated
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(
			@RequestParam(defaultValue = "1")@Min(1) Integer page,
			@RequestParam(defaultValue = "10")@Min(1) Integer size) {
		List<Course> courses = courseService.getAllCourses(page, size);
		ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
				.message("Successfully retrieved courses")
				.status(HttpStatus.OK)
				.payload(courses)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{course-id}")
	public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id")@Min(1) Long courseId) {
		Course course = courseService.getCourseById(courseId);
		ApiResponse<Course> response = ApiResponse.<Course>builder()
				.message("Successfully retrieved course")
				.status(HttpStatus.OK)
				.payload(course)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Course>> createCourse(@Valid @RequestBody CourseRequest request) {
		Course createdCourse = courseService.createCourse(request);
		ApiResponse<Course> response = ApiResponse.<Course>builder()
				.message("Successfully created course")
				.status(HttpStatus.CREATED)
				.payload(createdCourse)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{course-id}")
	public ResponseEntity<ApiResponse<Course>> updateCourse(
			@PathVariable("course-id") Long courseId,
			@Valid @RequestBody CourseRequest request) {
		Course updatedCourse = courseService.updateCourse(courseId, request);
		ApiResponse<Course> response = ApiResponse.<Course>builder()
				.message("Successfully updated course")
				.status(HttpStatus.OK)
				.payload(updatedCourse)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{course-id}")
	public ResponseEntity<DeleteResponse<Course>> deleteCourse(@PathVariable("course-id") Long courseId) {
		courseService.deleteCourse(courseId);
		DeleteResponse<Course> response = DeleteResponse.<Course>builder()
				.message("Successfully deleted course")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
