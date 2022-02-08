package com.springboot.placenote.web.dto.board;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardFileDto {
	private int board_id;

	private int user_id;
	private String profile_img;
	private String writer;
	private String board_content;
	private String heart;
	private String follow;
	private List<String> file_name;

	private LocalDateTime update_date;
	private String update;
	
}
