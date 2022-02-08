package com.springboot.placenote.domain.heart;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartRepository {
	public int heart(Heart heart);
	public int heartCancel(Heart heart);
	public int isHearted(Heart heart);
}
