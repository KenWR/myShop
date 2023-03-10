package com.green.nowon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.GoodsInsertDTO;
import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService service;
	
	@PostMapping("/admin/goods")
	public String goods(GoodsInsertDTO dto, MultipartFile[] gimg) { //goods/reg.html의 125근처에 있는 name
		//System.out.println(dto);
		service.save(dto, gimg);
		return "goods/reg";
	}
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}
	
	@ResponseBody//응답데이터를 json타입으로 리턴
	@PostMapping("/admin/temp-upload")
	public Map<String, String> tempUpload(MultipartFile gimg) {
		return service.fileTempUpload(gimg);
	}

}
