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
public class UserDtl {
    
	private int id;
	
	private String profile_img;
	private int following_count;
	private int follower_count;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
