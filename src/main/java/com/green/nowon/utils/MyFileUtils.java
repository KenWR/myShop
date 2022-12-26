package com.green.nowon.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUtils {

	public static Map<String, String> fileUpload(MultipartFile gimg, String location) {
		ClassPathResource cpr=new ClassPathResource("static"+location);
		File folder=null;
		String fileName=null;
		String orgName=null;
		try {
			folder=cpr.getFile();
			orgName=gimg.getOriginalFilename();
			
			int idx=orgName.indexOf(".");//파일 이름중에서 마지막 "."의 인덱스 번호
			fileName=orgName.substring(0, idx)
				+"_"+(System.nanoTime()/1000000)
				+orgName.substring(idx);	// . + 확장자

			//원본이름_랜덤숫자.jpg 이런식으로 만든다는 뜻
			gimg.transferTo(new File(folder, fileName));
			
			System.out.println("임시폴더에 업로드 위치 : " +location+fileName);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		Map<String, String> tempfile=new HashMap<>();
		tempfile.put("location", location);
		tempfile.put("fileName", fileName);
		tempfile.put("url", location+fileName);
		return tempfile;
		
		
	}
	
	private MyFileUtils() {
		
	}

}
