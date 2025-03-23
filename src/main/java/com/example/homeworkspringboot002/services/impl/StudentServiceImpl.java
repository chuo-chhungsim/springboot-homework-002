package com.example.homeworkspringboot002.services.impl;

import com.example.homeworkspringboot002.Exception.NoContentException;
import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;
import com.example.homeworkspringboot002.repository.StudentCourseRepository;
import com.example.homeworkspringboot002.repository.StudentRepository;
import com.example.homeworkspringboot002.services.StudentService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;
	private final StudentCourseRepository studentCourseRepository;

	public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
		this.studentRepository = studentRepository;
		this.studentCourseRepository = studentCourseRepository;
	}


	@Override
	public List<Student> getAllStudent(Integer page, Integer size) {
		page = (page - 1) * size;
		return studentRepository.getAllStudent(page, size);
	}

	@Override
	public Student getStudentById(Long studentId) {
		Student student = studentRepository.getStudentById(studentId);
		if (student == null) {
			throw new NoContentException("Student not found");
		}
		return student;
	}

	@Override
	public Student createStudent(StudentRequest request) {
		Student student = studentRepository.createstudent(request);
		for (Long courseId : request.getCourseId()) {
			studentCourseRepository.insertStudentIdAndCourseId(student.getStudentId(), courseId);
		}
		return studentRepository.getStudentById(student.getStudentId());
	}

	@Override
	public Student updateStudent(Long studentId, StudentRequest request) {
		Student student = studentRepository.updateStudent(studentId, request);

		studentCourseRepository.deleteStudentIdAndCourseId(studentId);
		for (Long courseId : request.getCourseId()) {
			studentCourseRepository.insertStudentIdAndCourseId(studentId, courseId);
		}

		return studentRepository.getStudentById(student.getStudentId());
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteStudent(studentId);
	}

	@Override
	@Transactional
	public void removeCourseFromStudent(Long studentId, Long courseId) {
		studentCourseRepository.removeStudentCourse(studentId, courseId);
	}

	// Delete all course associations for a student
	@Override
	@Transactional
	public void removeAllCoursesFromStudent(Long studentId) {
		studentCourseRepository.removeAllStudentCourses(studentId);
	}
}
