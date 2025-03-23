package com.example.homeworkspringboot002.repository;

import com.example.homeworkspringboot002.Model.Entity.Course;
import com.example.homeworkspringboot002.Model.dto.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
	@Results(id = "CourseMapper", value = {
			@Result(property = "courseId", column = "course_id"),
			@Result(property = "courseName", column = "course_name"),
			@Result(property = "description", column = "description"),
			@Result(property = "instructor", column = "instructor_id",
			one = @One(select = "com.example.homeworkspringboot002.repository.InstructorRepository.getInstructorById"))
	})
	@Select("""
			SELECT *
			FROM courses
			OFFSET #{page} LIMIT #{size};
			""")
	List<Course> getAllCourses(@Param("page") Integer page, @Param("size") Integer size);

	@ResultMap("CourseMapper")
	@Select("""
			SELECT *
			FROM courses
			WHERE course_id = #{course-id}
			""")
	Course getCourseById(@Param("course-id") Long courseId);
	
	@ResultMap("CourseMapper")
	@Select("""
			INSERT INTO courses
			VALUES (default,#{request.courseName},#{request.instructorId}, #{request.description})
			RETURNING *
			""")
	Course createCourse(@Param("request") CourseRequest request);

	@ResultMap("CourseMapper")
	@Select("""
			UPDATE courses
			SET course_name = #{request.courseName},
			    description = #{request.description},
			    instructor_id = #{request.instructorId}
			WHERE course_id = #{course-id}
			RETURNING *
			""")
	Course updateCourse(@Param("course-id") Long courseId, @Param("request") CourseRequest request);

	@Delete("""
			DELETE FROM courses
			WHERE course_id = #{courseId}
			""")
	void deleteCourse(@Param("courseId") Long courseId);
}