package com.springboot.placenote.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public User getUserByUsername(String username);
	public int checkUsernameByUsername(String username);
	public UserDtl getUserDtlById(int id);
	public int insertUser(User user);
	
}
