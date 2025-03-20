package com.example.homeworkspringboot002.repository;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import com.example.homeworkspringboot002.Model.dto.request.InstructorRequest;
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


	@ResultMap("InstructorMapper")
	@Select("""
            SELECT *
            FROM instructors
            WHERE instructor_id = #{instructor-id}
            """)
	Instructor getInstructorById(@Param("instructor-id") Long instructorId);

	@ResultMap("InstructorMapper")
	@Select("""
            INSERT INTO instructors
            VALUES (default,#{request.instructorName}, #{request.email})
            RETURNING *
            """)
	Instructor createInstructor(@Param("request") InstructorRequest request);

	@ResultMap("InstructorMapper")
	@Select("""
            UPDATE instructors
            SET instructor_name = #{request.instructorName},
                email = #{request.email}
            WHERE instructor_id = #{instructor-id}
            RETURNING *
            """)
	Instructor updateInstructor(@Param(("instructor-id")) Long instructorId,@Param("request") InstructorRequest request);

	@Delete("""
            DELETE FROM instructors
            WHERE instructor_id = #{instructor-id}
            """)
	void deleteInstructor(@Param("instructor-id") Long instructorId);

}
