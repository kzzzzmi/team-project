package com.springboot.placenote.domain.board;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardFile {
	private int file_id;
	
	private int board_id;
	private String file_name;
	
	private LocalDateTime create_date;
}
