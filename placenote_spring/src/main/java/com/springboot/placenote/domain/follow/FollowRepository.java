package com.springboot.placenote.domain.follow;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowRepository {
	//follow 
	public int follow(Follow follow);
	public int followCancel(Follow follow);
	public Follow getFollow(Follow follow);
	public int getFollowingCount(int username);
	public int getFollowerCount(int username);
	public int getFollowingNum(String username);
	public int getFollowerNum(String username);

	
	public List<Follow>getFollower(int userid);
	public List<Follow> getFollowing(int userid);
	public int isFollowed(Follow follow);
	public int isFollowered(Follow follow);
	
}
