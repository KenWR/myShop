package com.green.nowon.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.green.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "gen_mem", sequenceName = "seq_mem", initialValue = 1, allocationSize = 1)
@Table(name = "my_member")
@Entity
public class MemberEntity extends BaseDateEntity{
	
	@GeneratedValue(generator = "gen_mem", strategy = GenerationType.SEQUENCE)
	@Id
	private long mno;//회원번호
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String pass;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true)
	private String nickName;
	
	//기본값 = false 
	private boolean social;//소셜여부확인
	private boolean deleted;//탈퇴여부확인

	//ROLE--enum
	@Builder.Default
	@Enumerated(EnumType.STRING)//설정하지 않을시 ordinal이 기본값으로 됨
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<MyRole> roles=new HashSet<>();
	
	//ROLE 적용을 위한 편의 메소드
	public MemberEntity addRole(MyRole role) {
		roles.add(role);
		return this;
	}
}
