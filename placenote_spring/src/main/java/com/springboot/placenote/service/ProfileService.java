package com.springboot.placenote.service;


import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.user.Follow;
import com.springboot.placenote.web.dto.auth.FollowRespDto;
import com.springboot.placenote.web.dto.auth.ProfileRespDto;

public interface ProfileService {

    public ProfileRespDto getProfile(PrincipalDetails principalDetails, String username);
    
    public void follow(int fromUserId, int toUserId);
    public void followCancel(int fromUserId, int toUserId);
    
    public FollowRespDto getFollower( PrincipalDetails principalDetails , int userId);
    public FollowRespDto getFollowing(PrincipalDetails principalDetailsint, int userId);
   
}
