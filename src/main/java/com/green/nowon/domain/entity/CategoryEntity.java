package com.green.nowon.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "category")
@Entity
public class CategoryEntity {
	
	//1~4차
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String name;
	private int depth;
	
	@JoinColumn//fk : parent_no
	@ManyToOne
	private CategoryEntity parent;

}
