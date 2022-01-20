package com.springboot.placenote.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.placenote.config.auth.PrincipalDetails;
import com.springboot.placenote.domain.board.BoardRepository;
import com.springboot.placenote.web.dto.board.BoardReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	public boolean insertBoard(BoardReqDto boardReqDto, PrincipalDetails principalDetails) {
		List<MultipartFile> files = boardReqDto.getFiles();
		int result = 0;
		
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
			
			
		}	
		return false;
	}
	
}
