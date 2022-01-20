package com.springboot.placenote.domain.board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {

	public int insertBoard(Board board);
	public int insertFiles(Board board);
	
}
