package com.springboot.placenote.domain.board;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Board {
	private int board_id;
	private int file_id;
	
	private int writer;
	private String keyword;
	private String place_name;
	private String location;
	private String board_content;
	private List<String> file_name;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
