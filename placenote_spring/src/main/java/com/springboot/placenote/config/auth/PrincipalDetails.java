package com.springboot.placenote.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails , OAuth2User {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private UserDtl userDtl;
	private Map<String,Object>attributes;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	public PrincipalDetails(User user , UserDtl userDtl) {
		this.user = user;
		this.userDtl = userDtl;
	}
	
	public PrincipalDetails(User user , UserDtl userDtl , Map<String, Object>attributes) {
		this.user = user;
		this.userDtl = userDtl;
		this.attributes = attributes;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
	    return attributes;
	}

	@Override
	public String getName() {
	    return (String)attributes.get("name");
	}
}
