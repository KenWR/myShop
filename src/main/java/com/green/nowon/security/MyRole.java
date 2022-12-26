package com.green.nowon.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum MyRole {
	
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	private final String role;

}
