package com.green.nowon.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	Optional<CategoryEntity> findByName(String categoryName);

	//상위 카테고리가 null인 요소 : 1차 카테고리
	List<CategoryEntity> findAllByParentNoIsNull();

	List<CategoryEntity> findAllByParentNo(long parentNo);	


	
	

}
