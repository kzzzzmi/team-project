package com.springboot.placenote.web.dto.auth;

import lombok.Data;


@Data
public class ProfileRespDto {

    
    private int userid;
    private String username;
    private String profile_img;
    private String follow;
    private int boardContent;
    private int boardImgCount;
    private int followCount;
    private int followingCount;
}
