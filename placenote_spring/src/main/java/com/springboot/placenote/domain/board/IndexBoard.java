package com.springboot.placenote.domain.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class IndexBoard {
	private int board_id;
	
	private String profile_img;
	private String writer;
	private String board_content;
	private String file_name;
	
	private LocalDateTime update_date;
}
