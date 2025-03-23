package com.example.homeworkspringboot002.services;

import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService {
	List<Student> getAllStudent(Integer page,Integer size);

	Student getStudentById(Long studentId) ;

	Student createStudent(StudentRequest request);

	Student updateStudent(Long studentId, StudentRequest studentRequest) throws NotFoundException;

	void deleteStudent(Long studentId);

	@Transactional
	void removeCourseFromStudent(Long studentId, Long courseId);

	// Delete all course associations for a student
	@Transactional
	void removeAllCoursesFromStudent(Long studentId);
}
