package com.example.homeworkspringboot002.services.impl;

import com.example.homeworkspringboot002.Model.Entity.Instructor;
import com.example.homeworkspringboot002.Model.dto.request.InstructorRequest;
import com.example.homeworkspringboot002.repository.InstructorRepository;
import com.example.homeworkspringboot002.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {
	private final InstructorRepository instructorRepository;

	@Override
	public List<Instructor> geyAllInstructors(Integer page, Integer size) {
		page = (page -1) * size;
		return instructorRepository.getAllInstructors(page, size);
	}

	@Override
	public Instructor getInstructorById(Long instructorId) {
		return instructorRepository.getInstructorById(instructorId);
	}

	@Override
	public Instructor createInstructor(InstructorRequest request) {
		return instructorRepository.createInstructor(request);
	}

	@Override
	public Instructor updateInstructor(Long instructorId, InstructorRequest request) {
		return instructorRepository.updateInstructor(instructorId,request);
	}

	@Override
	public void deleteInstructor(Long instructorId) {
		instructorRepository.deleteInstructor(instructorId);
	}
}
