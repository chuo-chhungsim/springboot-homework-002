package com.example.homeworkspringboot002.repository;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {
	@Results(id = "InstructorMapper",value = {
			@Result(property = "instructorId",column = "instructor_id"),
			@Result(property = "instructorName",column = "instructor_name")
	})
	@Select("""
			SELECT *
			FROM instructors
			OFFSET #{page} LIMIT #{size};
			""")
	List<Instructor> getAllInstructors(@Param("page") Integer page, @Param("size") Integer size);
}
