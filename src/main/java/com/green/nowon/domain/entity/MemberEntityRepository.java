package com.green.nowon.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{

	//쿼리 메소드 유형 : 문법에 맞지 않을시 오류 ... 서버가 켜지지도 않는다.
	Optional<MemberEntity> findByEmailAndSocialAndDeleted(String username, boolean b, boolean c);
	
	

}
