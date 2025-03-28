package com.example.homeworkspringboot002.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Long studentId;
	private String studentName;
	private String email;
	private String phoneNumber;
	private List<Course> courses;
}
