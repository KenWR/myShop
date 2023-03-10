package com.green.nowon.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.domain.entity.CategoryRepository;
import com.green.nowon.service.GoodsService;
import com.green.nowon.utils.MyFileUtils;

@Service
public class GoodsServiceProcess implements GoodsService {
	
	@Value("${file.location.temp}")
	private String locationTemp;

	@Override
	public Map<String, String> fileTempUpload(MultipartFile gimg) {

		return MyFileUtils.fileUpload(gimg, locationTemp);
	}

	@Override
	public void save(GoodsInsertDTO dto, MultipartFile[] gimg) {
		// 카테고리와 상품등록
		// 이미지 정보 등록, temp->실제 upload위치
		
		
	}





}
