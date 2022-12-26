package com.green.nowon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.MemberInsertDTO;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.LogService;

@Service
public class LogServiceProcess implements LogService {
	
	
	//DAO :: jpa Repository
	
	@Autowired
	private MemberEntityRepository meRe;
	
	@Autowired
	private PasswordEncoder pe;
	
	//회원가입처리
	@Override
	public void save(MemberInsertDTO dto) {
		//비밀번호 인코딩,
		//role 정보 세팅이 아직 안되어있음
		meRe.save(dto.toEntity(pe).addRole(MyRole.USER));
		
	}
	
	

}
