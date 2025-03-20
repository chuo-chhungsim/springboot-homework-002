package com.example.homeworkspringboot002.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Long studentId;
	private String studentName;
	private String email;
	private String phoneNumber;
}
