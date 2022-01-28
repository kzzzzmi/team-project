package com.springboot.placenote.domain.user;



import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository {
	
	public User getUserByUsername(String username);
	public User getUserByOAuth2Username(String oauth2_username);
	public UserDtl getUserDtlById(int id);
	public int checkUsernameByUsername(String username);
	public int insertUser(User user);
	

	
}
