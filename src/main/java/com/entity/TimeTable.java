package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TimeTable {
	private Long id;
	private String subject;
	private String day;
	private String teacher;
	private String standard;
	private String period;
}
