package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseDateEntity {
	
	@CreationTimestamp
	LocalDateTime createdDate;
	@UpdateTimestamp
	LocalDateTime updatedDate;

}
