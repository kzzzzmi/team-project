package com.springboot.placenote.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {

	public int insertBoard(Board board);
	public List<IndexBoard> getBoardAll();
	public List<IndexBoard> getBoard(String keyword);
}
