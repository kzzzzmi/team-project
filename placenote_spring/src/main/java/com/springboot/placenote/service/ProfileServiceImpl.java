package com.springboot.placenote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.follow.Follow;
import com.springboot.placenote.domain.follow.FollowRepository;
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
	private final FollowRepository followRepository;

	@Override
	public ProfileRespDto getProfile(PrincipalDetails principalDetails, String username) {
		ProfileRespDto profileRespDto = new ProfileRespDto();
		User userEntity = userRepository.getUserByUsername(username);
		
		if (userEntity != null) {
			UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
			profileRespDto.setUserid(userEntity.getId());
			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(userDtlEntity.getProfile_img());
			profileRespDto.setFollowerCount(followRepository.getFollowerCount(userEntity.getId()));
			profileRespDto.setFollowingCount(followRepository.getFollowingCount(userEntity.getId()));
			if (principalDetails != null) {
				Follow followEntity = Follow.builder().from_userid(principalDetails.getUser().getId())
						.to_userid(profileRespDto.getUserid()).build();

				if (followRepository.getFollow(followEntity) != null) {
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
		followRepository.follow(followEntity);
	}

	@Override
	public void followCancel(int fromUserId, int toUserId) {
		Follow followEntity = Follow.builder().from_userid(fromUserId).to_userid(toUserId).build();
		followRepository.followCancel(followEntity);
	}

	@Override
	public FollowRespDto getFollower(PrincipalDetails principalDetails, int userId) {
		FollowRespDto followRespDto = new FollowRespDto();
		List<Follow> followList = followRepository.getFollower(userId);
		if (principalDetails != null) {
			for (Follow follow : followList) {
				Follow temp = new Follow();
				temp.setTo_userid(principalDetails.getUser().getId());
				temp.setFrom_userid(follow.getFrom_userid());
				if (temp.getFrom_userid() == principalDetails.getUser().getId()) {
					follow.setFollow("i");
				} else {
					if (followRepository.isFollowered(temp) == 1) {
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
		followRespDto.setFollowingCount(followRepository.getFollowingCount(userId));

		return followRespDto;
	}

	@Override
	public FollowRespDto getFollowing(PrincipalDetails principalDetails, int userId) {
		FollowRespDto followRespDto = new FollowRespDto();
		List<Follow> followList = followRepository.getFollowing(userId);
		if (principalDetails != null) {
			for (Follow follow : followList) {
				Follow temp = new Follow();
				temp.setFrom_userid(principalDetails.getUser().getId());
				temp.setTo_userid(follow.getTo_userid());
				if (temp.getFrom_userid() == temp.getTo_userid()) {
					follow.setFollow("i");
				} else {
					if (followRepository.isFollowed(temp) == 1) {
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
		followRespDto.setFollowerCount(followRepository.getFollowerCount(userId));
		
		return followRespDto;
	}

	@Override
	public ProfileRespDto getFollowCount(int id) {
		ProfileRespDto profileRespDto = new ProfileRespDto();
		profileRespDto.setFollowerCount(followRepository.getFollowerCount(id));
		profileRespDto.setFollowingCount(followRepository.getFollowingCount(id));
		return profileRespDto;
	}

	@Override
	public FollowRespDto getFollowCount(String username) {
		FollowRespDto followRespDto = new FollowRespDto();
		followRespDto.setFollowerCount(followRepository.getFollowerNum(username));
		followRespDto.setFollowingCount(followRepository.getFollowingNum(username));
		return followRespDto;
	}

}
