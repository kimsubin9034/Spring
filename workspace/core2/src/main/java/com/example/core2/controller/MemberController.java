package com.example.core2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.core2.dto.Member;
import com.example.core2.dto.MemberForm;
import com.example.core2.service.MemberService;

@Controller
public class MemberController {
	
	//Controller가 Service에 의존한다 라고 표현함 / 스프링으로서는 부적합함
	//MemberService mService = new MemberService();
	//Service는 여러 Controller에서 가져다 쓸 수 있기 때문에
	//Spring Container에 등록을 해야한다.
	//스프링스럽게 작업하기
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		//홈화면으로 돌리기
		return "redirect:/";
	}
	
	// /members, getMapping
	// list(Model model), return "members/memberList"
	
	@GetMapping("/members")
	public String list(Model model) {
	    List<Member> members = memberService.findMembers();
	    model.addAttribute("members", members); // 회원 목록을 모델에 추가

	    return "members/memberList"; // 뷰 이름 반환
	}

	
	
}
