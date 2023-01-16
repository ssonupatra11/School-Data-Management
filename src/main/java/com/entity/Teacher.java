package com.entity;
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
	private Long id;
	private String name;
	private String phno;
	private String address;
	private String email;
	private String qualification;
	private Double experience;
	private String classTeacher;
	private Long salary;
	private String subject;
	private String password;
}
