package com.springboot.placenote.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
	private int id;
	
	private String username;
	private String oauth2_username;
	private String password;
	private String provider;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private String role;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
