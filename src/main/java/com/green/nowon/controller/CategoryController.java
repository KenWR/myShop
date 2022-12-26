package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	
	@GetMapping("/admin/categories")
	public String category() {
		return "category/reg";
	}
	
	@PostMapping("/admin/categories")//category/reg.html의 10번대의 form의 action
	public String category(String[] name) {
		return "category/reg";
	}
	

}
