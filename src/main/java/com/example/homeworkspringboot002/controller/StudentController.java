package com.example.homeworkspringboot002.controller;

import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;
import com.example.homeworkspringboot002.Model.dto.response.ApiResponse;
import com.example.homeworkspringboot002.Model.dto.response.DeleteResponse;
import com.example.homeworkspringboot002.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1")Integer page,
	                                                                @RequestParam(defaultValue = "10")Integer size){
		List<Student> getAllStudents = studentService.getAllStudent(page, size);
		ApiResponse<List<Student>> response = ApiResponse.
				<List<Student>>builder()
				.message("All student fetch successfully")
				.status(HttpStatus.OK)
				.payload(getAllStudents)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	//DONE: implement get student by id
	@GetMapping("/{student-id}")
	public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long studentId){
		Student getStudentById = studentService.getStudentById(studentId);
		ApiResponse<Student> response = ApiResponse.
				<Student>builder()
                .message("Student fetch successfully")
                .status(HttpStatus.OK)
                .payload(getStudentById)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
	}
	//NOTE : implement create student
	@PostMapping
	public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentRequest request){
		Student createStudent = studentService.createStudent(request);
		ApiResponse<Student> response = ApiResponse.
				<Student>builder()
                .message("Student created successfully")
                .status(HttpStatus.CREATED)
                .payload(createStudent)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
	}
	@PutMapping("{student-id}")
	public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("student-id") Long studentId, StudentRequest studentRequest){
		Student updateStudent = studentService.updateStudent(studentId, studentRequest);
		ApiResponse<Student> response = ApiResponse.
				<Student>builder().
				message("Update Student"+ studentId +" successfully")
				.status(HttpStatus.OK)
				.payload(updateStudent)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("{student-id}")
	public ResponseEntity<DeleteResponse<Student>> deleteStudent(@PathVariable("student-id") Long studentId ){
		studentService.deleteStudent(studentId);
		DeleteResponse<Student> response = DeleteResponse.
				<Student>builder()
				.message("Delete Student successfully")
				.status(HttpStatus.OK)
				.time(LocalDateTime.now())
				.build();
		return ResponseEntity.ok(response);
	}
}
