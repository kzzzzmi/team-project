package com.springboot.placenote.domain.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Follow {
    
    	private int from_userid;
	private int to_userid;
	private String username;
	private String profile_img;
	private String follow;

}
