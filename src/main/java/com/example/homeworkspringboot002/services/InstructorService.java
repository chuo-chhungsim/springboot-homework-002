package com.example.homeworkspringboot002.services;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import com.example.homeworkspringboot002.Model.dto.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
	List<Instructor> geyAllInstructors(Integer page, Integer size);

	Instructor getInstructorById(Long instructorId);

	Instructor createInstructor(InstructorRequest request);

	Instructor updateInstructor(Long instructorId, InstructorRequest request);

	void deleteInstructor(Long instructorId);
}
