package com.example.homeworkspringboot002.repository;

import com.example.homeworkspringboot002.Model.Entity.Student;
import com.example.homeworkspringboot002.Model.dto.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

	//	Done : Implement Get All Student
	@Results(id = "StudentMapper", value = {
			@Result(property = "studentId", column = "student_id"),
			@Result(property = "studentName", column = "student_name"),
			@Result(property = "email", column = "email"),
			@Result(property = "phoneNumber", column = "phone_number")
	})
	@Select("""
			SELECT * FROM students
			OFFSET #{page} LIMIT #{size};
			""")
	List<Student> getAllStudent(@Param("page") Integer page, @Param("size") Integer size);


	//TODO : Implement Get Student By Id
	@ResultMap("StudentMapper")
	@Select("""
			SELECT * FROM students WHERE student_id = #{student_id};
			""")
	Student getStudentById(@Param("student_id") Long studentId);

	//TODO : Implement create Student
	@ResultMap("StudentMapper")
	@Select("""
			INSERT INTO students
			VALUES (default, #{request.studentName},#{request.email} ,#{request.phoneNumber}) RETURNING *;
			""")
	Student createstudent(@Param("request") StudentRequest request);

	@ResultMap("StudentMapper")
	@Select("""
			UPDATE students
			SET student_name = #{request.studentName},
			email = #{request.email},
			phone_number = #{request.phoneNumber}
			where student_id = #{student-id}
			RETURNING *;
			""")
	Student updateStudent(@Param("student-id") Long studentId,@Param("request") StudentRequest studentRequest);

	@Delete("""
			DELETE FROM students
			WHERE student_id = #{student-id};
			""")
	void deleteStudent(@Param("student-id") Long studentId);

}
