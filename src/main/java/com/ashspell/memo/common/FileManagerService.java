package com.ashspell.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	private String FILE_UPLOAD_PATH = "D:\\이강산\\springproject\\memo\\upload\\images/";
	
	
	
	// 파일 저장 후 접근 경로 리턴
	public String saveFile(int userId, MultipartFile file) {
		
		// 파일 경로
		// 파일 이름이 겹치는 것을 방지하기 위해 사용자 별로 폴더를 구분한다
		// 같은 사용자가 같은 파일이름 겹치는것을 방지하기위해 현재시간을 폴더이름에 포함시킨다
		// UNIX time : 1970년 1월 1일 0시0분0초 기준으로 현재 몇 millisecond 초가 지났는지
		// /images/6_24358234/asdf.jpg
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			// 디렉토리 생성 에러
			return null;
		}
		
		// 파일 저장
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		
		// <img src = "/images/6_24358234/test.png">
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
		
	}
}
