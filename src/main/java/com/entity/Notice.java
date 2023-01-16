package com.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
	private Long id;
	private String subject;
	private String message;
	private String producedBy;
	private String rsvp;
}

