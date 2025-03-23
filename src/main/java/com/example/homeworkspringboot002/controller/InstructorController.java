package com.example.homeworkspringboot002.controller;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import com.example.homeworkspringboot002.Model.dto.request.InstructorRequest;
import com.example.homeworkspringboot002.Model.dto.response.ApiResponse;
import com.example.homeworkspringboot002.Model.dto.response.DeleteResponse;
import com.example.homeworkspringboot002.services.InstructorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
@RequiredArgsConstructor
@Validated  // Enable method validation at the controller level
public class InstructorController {
	private final InstructorService instructorService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1")@Min(1) Integer page,
	                                                                       @RequestParam(defaultValue = "10")@Min(1) Integer size) {
		List<Instructor> getAllInstructor = instructorService.geyAllInstructors(page, size);
		ApiResponse<List<Instructor>> response = ApiResponse.
				<List<Instructor>>builder()
				.message("Successfully get all instructors")
				.status(HttpStatus.OK)
				.payload(getAllInstructor)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{instructor-id}")
	public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") @Positive(message = "Instructor ID must be positive") Long instructorId) {
		Instructor getInstructorById = instructorService.getInstructorById(instructorId);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
				.message("Successfully fetched instructor by ID")
				.status(HttpStatus.OK)
				.payload(getInstructorById)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Instructor>> createInstructor(@Valid @RequestBody InstructorRequest request) {
		Instructor createInstructor = instructorService.createInstructor(request);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
				.message("Successfully created instructor")
				.status(HttpStatus.CREATED)
				.payload(createInstructor)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{instructor-id}")
	public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor-id") @Positive(message = "Instructor ID must be positive") Long instructorId,
	                                                                @Valid @RequestBody InstructorRequest request) {
		Instructor updateInstructor = instructorService.updateInstructor(instructorId, request);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
				.message("Successfully updated instructor")
				.status(HttpStatus.OK)
				.payload(updateInstructor)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{instructor-id}")
	public ResponseEntity<DeleteResponse<Instructor>> deleteInstructor(@PathVariable("instructor-id") @Positive(message = "Instructor ID must be positive") Long instructorId) {
		instructorService.deleteInstructor(instructorId);
		DeleteResponse<Instructor> response = DeleteResponse.
				<Instructor>builder()
				.message("Successfully deleted instructor")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
