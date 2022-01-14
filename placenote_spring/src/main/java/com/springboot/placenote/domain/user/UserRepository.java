package com.springboot.placenote.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	public User getUserByUsername(String username);
	
}
