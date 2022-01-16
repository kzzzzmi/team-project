package com.springboot.placenote.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserDtl {
	private int id;
	
	private String profile_img;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
