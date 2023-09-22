package com.example.core2.repository;

import java.util.List;

import com.example.core2.dto.Member;

public interface MemberRepository {
		//회원 저장
		Member save(Member member);
		//전체 조회
		List<Member> findAll();
}
