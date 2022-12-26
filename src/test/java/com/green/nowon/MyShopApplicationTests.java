package com.green.nowon;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.green.nowon.domain.entity.CategoryEntity;
import com.green.nowon.domain.entity.CategoryRepository;
import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.domain.entity.MemberEntityRepository;
import com.green.nowon.security.MyRole;

@SpringBootTest
class MyShopApplicationTests {

	@Autowired
	MemberEntityRepository mRepo;
	
	@Autowired
	PasswordEncoder pe;
	
	//@Test
	void 어드민계정() {
		mRepo.save(MemberEntity.builder()
				.email("admin@test.com").pass(pe.encode("1234")).name("관리자").nickName("관리자")
				.build()
				.addRole(MyRole.USER)
				.addRole(MyRole.ADMIN)
				);
	

	}
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Commit
	@Transactional

	
	//@Test
	void first카테고리생성_테스트() {
		categoryRepository.save(CategoryEntity.builder()
				.name("의류")
				.build());
	}
	
	//@Test
	void second카테고리생성_테스트() {
		
		categoryRepository.save(CategoryEntity.builder()
				.name("스웨터")
				//상위카테고리 설정
				.parent(CategoryEntity.builder().no(9).build())
				.build());
	}

}
