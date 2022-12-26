package com.green.nowon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.MemberInsertDTO;
import com.green.nowon.service.LogService;

@Controller
public class LogController {
	
	@Autowired
	LogService service;
	
	@GetMapping("/member/login")
	public String login() {
		return "log/login";
	}
	
	@GetMapping("/member/signup")
	public String join() {
		return "log/signup";
	}
	
	//회원가입 처리를위해
	@PostMapping("/member/signup")
	public String join(MemberInsertDTO dto) {
		service.save(dto);
		return "redirect:/member/login";//회원가입후 로그인페이지로 가게
	}

}
