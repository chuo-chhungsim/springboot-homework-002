package com.example.homeworkspringboot002.services;

import com.example.homeworkspringboot002.Model.Entity.Course;
import com.example.homeworkspringboot002.Model.dto.request.CourseRequest;

import java.util.List;

public interface CourseService {

	List<Course> getAllCourses(Integer page, Integer size);

	Course getCourseById(Long courseId);

	Course createCourse(CourseRequest request);

	Course updateCourse(Long courseId, CourseRequest request);

	void deleteCourse(Long courseId);
}
