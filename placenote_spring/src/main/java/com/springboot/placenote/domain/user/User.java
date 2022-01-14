package com.springboot.placenote.domain.user;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private int id;
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private String role;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
