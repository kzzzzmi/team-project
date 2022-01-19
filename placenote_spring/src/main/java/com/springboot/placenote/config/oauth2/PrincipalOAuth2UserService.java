package com.springboot.placenote.config.oauth2;

import java.util.Map;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.config.oauth2.provider.OAuth2UserDto;
import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;
import com.springboot.placenote.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		Map<String, Object> oAuth2UserAttributes = oAuth2User.getAttributes();
		String provider = userRequest.getClientRegistration().getRegistrationId();
		String providerId = "";
		if (provider.equals("naver")) {
			oAuth2UserAttributes = (Map<String, Object>) oAuth2User.getAttributes().get("response");
			providerId = (String) oAuth2UserAttributes.get("id");
		} else {
			providerId = UUID.randomUUID().toString().replaceAll("-", "");
		}
		String oauth2_username = provider + "_" + providerId;

		String gender = (String) oAuth2UserAttributes.get("gender");
		if (gender.equals("M")) {
			gender = "남성";
		} else {
			gender = "여성";
		}

		String mobile = (String) oAuth2UserAttributes.get("mobile");
		mobile = mobile.replace("-", "");
		OAuth2UserDto oAuth2UserDto = OAuth2UserDto.builder().oauth2_username(oauth2_username)
				.email((String) oAuth2UserAttributes.get("email")).name((String) oAuth2UserAttributes.get("name"))
				.provider(provider).role("ROLE_USER").gender(gender).phone(mobile).build();

		User userEntity = userRepository.getUserByOAuth2Username(oauth2_username);
		if (userEntity == null) {
			userEntity = oAuth2UserDto.toEntity();
			userEntity.setPassword(new BCryptPasswordEncoder().encode("&#$%$#%$#%$#56456561%"));
			userRepository.insertUser(userEntity);
			userEntity = userRepository.getUserByOAuth2Username(oauth2_username);
		}
		UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());

		return new PrincipalDetails(userEntity, userDtlEntity, oAuth2UserAttributes);
	}
}
