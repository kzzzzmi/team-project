package com.springboot.placenote.domain.follow;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowRepository {
	//follow 
	public int follow(Follow follow);
	public int followCancel(Follow follow);
	public Follow getFollow(Follow follow);

	
	public List<Follow>getFollower(int userid);
	public List<Follow> getFollowing(int userid);
	public int isFollowed(Follow follow);
	public int isFollowered(Follow follow);
	public int followTotalCount(String username);
	
}
