package com.example.homeworkspringboot002.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {
	private Long instructorId;
	private String instructorName;
	private String email;
}