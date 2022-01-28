package com.springboot.placenote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.user.Follow;
import com.springboot.placenote.domain.user.User;
import com.springboot.placenote.domain.user.UserDtl;
import com.springboot.placenote.domain.user.UserRepository;
import com.springboot.placenote.web.dto.auth.FollowRespDto;
import com.springboot.placenote.web.dto.auth.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    @Override
    public ProfileRespDto getProfile(PrincipalDetails principalDetails, String username) {
	ProfileRespDto profileRespDto = new ProfileRespDto();
	User userEntity = userRepository.getUserByUsername(username);
	if (userEntity != null) {
	    UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
	    profileRespDto.setUserid(userEntity.getId());
	    profileRespDto.setUsername(username);
	    profileRespDto.setProfile_img(userDtlEntity.getProfile_img());
	    if (principalDetails != null) {
		Follow followEntity = Follow.builder().from_userid(principalDetails.getUser().getId())
			.to_userid(profileRespDto.getUserid()).build();

		if (userRepository.getFollow(followEntity) != null) {
		    profileRespDto.setFollow("팔로우 취소");

		} else {
		    profileRespDto.setFollow("팔로우");
		}

	    }
	}
	return profileRespDto;
    }

    @Override
    public void follow(int fromUserId, int toUserId) {
	Follow followEntity = Follow.builder().from_userid(fromUserId).to_userid(toUserId).build();
	userRepository.follow(followEntity);

    }

    @Override
    public void followCancel(int fromUserId, int toUserId) {
	Follow followEntity = Follow.builder().from_userid(fromUserId).to_userid(toUserId).build();
	userRepository.followCancel(followEntity);
    }

    @Override
    public FollowRespDto getFollower(PrincipalDetails principalDetails , int userId) {
	FollowRespDto followRespDto = new FollowRespDto();
	List<Follow> followList = userRepository.getFollower(userId);
	if (principalDetails != null) {
	    for (Follow follow : followList) {
		Follow temp = new Follow();
		temp.setTo_userid(principalDetails.getUser().getId());
		temp.setFrom_userid(follow.getFrom_userid());
		if (temp.getFrom_userid() == principalDetails.getUser().getId()) {
		    follow.setFollow("i"); 
		  
		}else {
		    if (userRepository.isFollowered(temp) == 1) {
			follow.setFollow("팔로우 취소");
		    } else {
			follow.setFollow("팔로우");
		    }
		}
	    }
	    followRespDto.setLoginCheck(true);
	} else {
	    for (Follow follow : followList) {
		follow.setFollow("팔로우");
	    }
	    followRespDto.setLoginCheck(false);
	}

	followRespDto.setFollowList(followList);

	return followRespDto;
    }
    

    @Override
    public FollowRespDto getFollowing(PrincipalDetails principalDetails, int userId) {
	FollowRespDto followRespDto = new FollowRespDto();
	List<Follow> followList = userRepository.getFollowing(userId);
	if (principalDetails != null) {
	    for (Follow follow : followList) {
		Follow temp = new Follow();
		temp.setFrom_userid(principalDetails.getUser().getId());
		temp.setTo_userid(follow.getTo_userid());
		if (temp.getFrom_userid() == temp.getTo_userid()) {
		    follow.setFollow("i"); 
		}else {
		    if (userRepository.isFollowed(temp) == 1) {
			follow.setFollow("팔로우 취소");
		    } else {
			follow.setFollow("팔로우");
		    }
		}
	    }
	    followRespDto.setLoginCheck(true);
	} else {
	    for (Follow follow : followList) {
		follow.setFollow("팔로우");
	    }
	    followRespDto.setLoginCheck(false);
	}

	followRespDto.setFollowList(followList);

	return followRespDto;
    }

}
