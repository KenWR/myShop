package com.green.nowon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.entity.CategoryEntity;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.service.CategoryService;

@Service
public class CategoryServiceProcess implements CategoryService {
	
	@Autowired
	private CategoryEntityRepository ceRepo;

	@Override
	public void save(String[] names) {
		
		//공통점은 null일때 대체하는 객체를 리턴
		//orElse() : null값이 아니라도 orElse내부가 실행
		//orElseGet() : null값을때만 orElseGet내부가 실행
		
		
		//1차 카테고리 조회하는 식
		//부모 카테고리가 null이고 이름이 일치하는애들중에 일치안하면 save를 실행
		CategoryEntity cate1 = ceRepo.findByParentNoNullAndName(names[0])
				.orElseGet(()->ceRepo.save(CategoryEntity.builder().name(names[0]).depth(1).build()));
		
		CategoryEntity cate2 = ceRepo.findByParentNoAndName(cate1.getNo(), names[1])
				.orElseGet(()->ceRepo.save(CategoryEntity.builder().name(names[1]).depth(2).parent(cate1).build()));
		
		CategoryEntity cate3 = ceRepo.findByParentNoAndName(cate2.getNo(), names[2])
				.orElseGet(()->ceRepo.save(CategoryEntity.builder().name(names[2]).depth(3).parent(cate2).build()));
		
		CategoryEntity cate4 = ceRepo.findByParentNoAndName(cate3.getNo(), names[3])
				.orElseGet(()->ceRepo.save(CategoryEntity.builder().name(names[3]).depth(4).parent(cate3).build()));
	
		
	}

	@Override
	public boolean isReg(String text) {
		Optional<CategoryEntity> result = ceRepo.findByParentNoNullAndName(text);
		if(result.isEmpty()) {
			return true;
		}
		return false;
	}

	//1차 카테고리 리스트
	@Override
	public void firstCategory(Model model) {
		//model.addAttribute("list", ceRepo.findByDepthOrderByNameAsc(1));
		//model.addAttribute("list", ceRepo.findByParentNoIsNullOrderByNameAsc());
		model.addAttribute("list", ceRepo.findByParentNoOrderByNameAsc(null));
		//ceRepo.findByParentNoIsNullOrderByNameAsc();
		//ceRepo.findByParentNoOrderByNameAsc(null);
		
	}

	@Override
	public void categoryList(Long parentNo, Model model) {
		if(parentNo.intValue()==0)parentNo=null;//null 은 1차카테고리
		model.addAttribute("list", ceRepo.findByParentNoOrderByNameAsc(parentNo));
		
	}

}
