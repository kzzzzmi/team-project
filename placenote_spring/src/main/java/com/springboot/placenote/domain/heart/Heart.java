package com.springboot.placenote.domain.heart;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Heart {
	private int board_id;
	private int user_id;
}
