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
		return instructorRepository.getAllInstructors(page, size);
	}

	@Override
	public Instructor getInstructorById(Long instructorId) {
		return null;
	}

	@Override
	public Instructor createInstructor(InstructorRequest request) {
		return null;
	}

	@Override
	public Instructor updateInstructor(Long instructorId, InstructorRequest request) {
		return null;
	}

	@Override
	public void deleteInstructor(Long instructorId) {

	}
}
