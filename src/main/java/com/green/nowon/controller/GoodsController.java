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

import com.green.nowon.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService service;
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/reg";
	}
	
	@ResponseBody
	@PostMapping("/admin/temp-upload")
	public Map<String, String> tempUpload(MultipartFile gimg) {
		return service.fileTempUpload(gimg);
	}

}
