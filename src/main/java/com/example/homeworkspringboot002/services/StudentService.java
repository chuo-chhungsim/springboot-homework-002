package com.example.homeworkspringboot002.services;

import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;

import java.util.List;

public interface StudentService {
	List<Student> getAllStudent(Integer page,Integer size);

	Student getStudentById(Long studentId);

	Student createStudent(StudentRequest request);

	Student updateStudent(Long studentId, StudentRequest studentRequest);

	void deleteStudent(Long studentId);
}
