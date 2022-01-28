package com.springboot.placenote.web.dto.auth;

import java.util.List;

import com.springboot.placenote.domain.follow.Follow;

import lombok.Data;

@Data
public class FollowRespDto {

   private List<Follow> followList;
   private boolean loginCheck;
}
