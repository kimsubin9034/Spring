package com.codingbox.core2_1.repository;

import java.util.List;

import com.codingbox.core2_1.dto.saram;

public interface MemberRepository {
	saram save(saram member);
	
	List<saram> findAll();
}
