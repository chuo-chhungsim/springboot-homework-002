package com.example.homeworkspringboot002.services.impl;

import com.example.homeworkspringboot002.Model.Entity.Course;
import com.example.homeworkspringboot002.Model.dto.request.CourseRequest;
import com.example.homeworkspringboot002.repository.CourseRepository;
import com.example.homeworkspringboot002.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getAllCourses(Integer page, Integer size) {
		page = (page -1) * size;
		return courseRepository.getAllCourses(page, size);
	}

	@Override
	public Course getCourseById(Long courseId) {
		return courseRepository.getCourseById(courseId);
	}

	@Override
	public Course createCourse(CourseRequest request) {
		return courseRepository.createCourse(request);
	}

	@Override
	public Course updateCourse(Long courseId, CourseRequest request) {
		return courseRepository.updateCourse(courseId, request);
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteCourse(courseId);
	}
}