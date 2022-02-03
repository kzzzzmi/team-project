package com.springboot.placenote.domain.follow;

import com.springboot.placenote.web.dto.auth.ProfileRespDto;

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
	
	private int following_count;
	private int follower_count;
	
	public ProfileRespDto toProfileRespDto() {
		return ProfileRespDto.builder()
				.followingCount(following_count)
				.followerCount(follower_count)
				.build();
	}

}
