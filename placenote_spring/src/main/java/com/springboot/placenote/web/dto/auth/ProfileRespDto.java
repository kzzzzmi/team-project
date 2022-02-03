package com.springboot.placenote.web.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileRespDto {
    private int userid;
    private String username;
    private String profile_img;
    private String follow;
    private int boardCount;
    private int boardImgCount;
    private int followerCount;
    private int followingCount;
}
