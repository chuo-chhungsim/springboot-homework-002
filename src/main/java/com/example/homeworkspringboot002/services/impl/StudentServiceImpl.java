package com.example.homeworkspringboot002.services.impl;

import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;
import com.example.homeworkspringboot002.repository.StudentRepository;
import com.example.homeworkspringboot002.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudent(Integer page, Integer size) {
		page = (page -1) * size;
		return studentRepository.getAllStudent(page, size);
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.getStudentById(studentId);
	}

	@Override
	public Student createStudent(StudentRequest request) {
		return studentRepository.createstudent(request);
	}

	@Override
	public Student updateStudent(Long studentId, StudentRequest studentRequest) {
		return studentRepository.updateStudent(studentId,studentRequest);
	}

	@Override
	public void deleteStudent(Long studentId) {
	studentRepository.deleteStudent(studentId);
	}
}
