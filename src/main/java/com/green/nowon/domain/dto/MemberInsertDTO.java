package com.green.nowon.domain.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.MemberEntity;

import lombok.Setter;

@Setter
public class MemberInsertDTO {
	
	private String email;
	private String pass;
	private String name;
	
	//최종적으로 DBㅇ에 저장될때에는 dto의 필드가 Entity클래스(MemberEntity)에 매핑
	public MemberEntity toEntity(PasswordEncoder pe) {
		return MemberEntity.builder()
				.email(email).pass(pe.encode(pass)).name(name)
				.build();
	}
	
}
