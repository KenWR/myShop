package com.green.nowon.service;

import org.springframework.ui.Model;

public interface CategoryService {

	void save(String[] name);

	boolean isReg(String text);

	void firstCategory(Model model);

	void categoryList(Long parentNo, Model model);

}
