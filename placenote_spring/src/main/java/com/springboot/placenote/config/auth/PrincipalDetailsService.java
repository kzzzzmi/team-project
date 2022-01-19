package com.springboot.placenote.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;
import com.springboot.placenote.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.getUserByUsername(username);
		if(userEntity == null) {
			return null;
		} else {
		    UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
			return new PrincipalDetails(userEntity , userDtlEntity);
		}	
	}

}
