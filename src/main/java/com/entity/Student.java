package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	private Long id;
	private String name;
	private String phno;
	private String address;
	private String email;
	private String grades;
	private String standard;
	private String parentPho;
	private String password;
}
