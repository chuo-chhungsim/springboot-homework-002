package com.example.homeworkspringboot002.repository;

import com.example.homeworkspringboot002.Model.Entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {

	// Get all courses for a specific student
	@Results(id = "studentCourseMapper", value = {
			@Result(property = "courseId", column = "course_id"),
			@Result(property = "courseName", column = "course_name"),
			@Result(property = "description", column = "description"),
			@Result(property = "instructor", column = "instructor_id",
					one = @One(select = "com.example.homeworkspringboot002.repository.InstructorRepository.getInstructorById"))
	})
	@Select("""
            SELECT c.* FROM students_course sc
            INNER JOIN courses c ON sc.course_id = c.course_id
            WHERE sc.student_id = #{studentId}
            """)
	List<Course> getCoursesByStudentId(Long studentId);

	@Insert("""
			INSERT INTO students_course
			VALUES (default,#{studentId},#{courseId})
			""")
	void insertStudentIdAndCourseId(Long studentId,Long courseId);

	@Delete("""
    DELETE FROM students_course WHERE student_id = #{studentId}
""")
	void deleteStudentIdAndCourseId(Long studentId);

	@Delete("""
            DELETE FROM student_course
            WHERE student_id = #{studentId}
              AND course_id = #{courseId}
            """)
	void removeStudentCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

	// Delete all courses for a student
	@Delete("""
            DELETE FROM student_course
            WHERE student_id = #{studentId}
            """)
	void removeAllStudentCourses(@Param("studentId") Long studentId);
}