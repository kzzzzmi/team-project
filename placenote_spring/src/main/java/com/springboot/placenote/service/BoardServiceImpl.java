package com.springboot.placenote.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.board.Board;
import com.springboot.placenote.domain.board.BoardRepository;
import com.springboot.placenote.domain.board.IndexBoard;
import com.springboot.placenote.web.dto.board.BoardReqDto;
import com.springboot.placenote.web.dto.board.BoardRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	public boolean insertBoard(BoardReqDto boardReqDto, PrincipalDetails principalDetails) {
		List<MultipartFile> files = boardReqDto.getFiles();
		List<String> boardImgs = new ArrayList<>();
		
		for(int i = 0; i < files.size(); i++) {
			String imgFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + files.get(i).getOriginalFilename();
			String boardImg = "board_img\\" + imgFileName;
			Path imgPath = Paths.get(filePath, boardImg);
			
			File file = new File(filePath + "board_img");
			if(!file.exists()) {
				file.mkdirs();
			}
			try {
				Files.write(imgPath, files.get(i).getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			boardImgs.add(boardImg);
		}	
		
		Board boardEntity = boardReqDto.toBoardEntity(principalDetails.getUser().getId(), boardImgs);	
		int result = boardRepository.insertBoard(boardEntity);
		
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public BoardRespDto getBoardAll(int page) {
		BoardRespDto boardRespDto = new BoardRespDto();
		List<IndexBoard> boardListAll = boardRepository.getBoardAll();
		System.out.println(boardListAll);
		List<IndexBoard> boardList = new ArrayList<>();
		
		int start = page * 5;
		int end = start + 5;
		
		while(start < end && start < boardListAll.size()) {
			boardList.add(boardListAll.get(start));
			start++;
		}
			
		boardRespDto.setBoardList(boardList);
		return boardRespDto;
	}
	
}
