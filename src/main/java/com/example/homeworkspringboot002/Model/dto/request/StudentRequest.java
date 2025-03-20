package com.example.homeworkspringboot002.Model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
	private String studentName;
	private String email;
	private String phoneNumber;
}
