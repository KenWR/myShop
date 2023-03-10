package com.green.nowon.service;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;

public interface GoodsService {

	Map<String, String> fileTempUpload(MultipartFile gimg);

	void save(GoodsInsertDTO dto, MultipartFile[] gimg);


}
