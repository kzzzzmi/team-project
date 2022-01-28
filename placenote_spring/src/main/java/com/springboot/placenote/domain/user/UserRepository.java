package com.springboot.placenote.domain.user;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.placenote.web.dto.auth.FollowRespDto;


@Mapper
public interface UserRepository {
	
	public User getUserByUsername(String username);
	public User getUserByOAuth2Username(String oauth2_username);
	public UserDtl getUserDtlById(int id);
	public int checkUsernameByUsername(String username);
	public int insertUser(User user);
	
	//follow 
	public int follow(Follow follow);
	public int followCancel(Follow follow);
	public Follow getFollow(Follow follow);

	
	public List<Follow>getFollower(int userid);
	public List<Follow> getFollowing(int userid);
	public int isFollowed(Follow follow);
	public int isFollowered(Follow follow);
	
	
}
