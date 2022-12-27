package com.green.nowon.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.service.CategoryService;
import com.green.nowon.service.impl.CategoryServiceProcess;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/admin/categories")
	public String category() {
		return "category/reg";
	}
	
	@ResponseBody
	@GetMapping("/admin/categories/{text}")
	public boolean category(@PathVariable String text) {
		
		return service.isReg(text);
	}
	@GetMapping("/common/layout/categories/{parentNo}")
	public String category(@PathVariable long parentNo, Model model) {
		service.categoryList(parentNo, model);
		return "category/ol-category";
	}
	
	//admin의 등록페이지
	@GetMapping("/common/categories")
	public String firstCategory(Model model) {
		service.firstCategory(model);
		return "category/category";
	}
	
	@GetMapping("/common/categories/{parentNo}")
	public String subCategory(@PathVariable long parentNo, Model model) {
		service.categoryList(parentNo, model);
		return "category/category";
	}

	
	@PostMapping("/admin/categories")//category/reg.html의 10번대의 form의 action
	public String category(String[] name) {
		service.save(name);
		return "category/reg";
	}
	

}
