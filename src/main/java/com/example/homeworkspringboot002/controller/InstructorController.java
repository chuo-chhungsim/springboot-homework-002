package com.example.homeworkspringboot002.controller;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import com.example.homeworkspringboot002.Model.dto.request.InstructorRequest;
import com.example.homeworkspringboot002.Model.dto.response.ApiResponse;
import com.example.homeworkspringboot002.Model.dto.response.DeleteResponse;
import com.example.homeworkspringboot002.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {
	private final InstructorService instructorService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Integer page,
	                                                                       @RequestParam(defaultValue = "10") Integer size) {
		List<Instructor> getAllInstructor = instructorService.geyAllInstructors(page, size);
		ApiResponse<List<Instructor>> response = ApiResponse.
				<List<Instructor>>builder()
				.message(("Successfully get all instructions"))
				.status(HttpStatus.OK)
				.payload(getAllInstructor)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/{instructor-id}")
	public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {
		Instructor getInstructorById = instructorService.getInstructorById(instructorId);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
                .message(("Successfully get instruction by id"))
                .status(HttpStatus.OK)
                .payload(getInstructorById)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
	}
	@PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorRequest request) {
		Instructor createInstructor = instructorService.createInstructor(request);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
                .message(("Successfully created instruction"))
                .status(HttpStatus.CREATED)
                .payload(createInstructor)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
	}
	@PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor-id") Long instructorId,
                                                              @RequestBody InstructorRequest request) {
		Instructor updateInstructor = instructorService.updateInstructor(instructorId, request);
		ApiResponse<Instructor> response = ApiResponse.
				<Instructor>builder()
				.message(("Successfully updated instruction"))
				.status(HttpStatus.OK)
				.payload(updateInstructor)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/{instructor-id}")
    public ResponseEntity<DeleteResponse<Instructor>> deleteInstructor(@PathVariable("instructor-id") Long instructorId) {
		instructorService.deleteInstructor(instructorId);
		DeleteResponse<Instructor> response = DeleteResponse.
				<Instructor>builder()
                .message(("Successfully deleted instruction"))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);

	}

}
