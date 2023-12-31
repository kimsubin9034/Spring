package com.codingbox.mylogin.domain.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
// : 생성자 안만들어도됨
public class MemberController {
	
	private final MemberRepository memberRepository;
	
	/*@ModelAttribute("member")Member member
	 * ->model.addAttribute("member", new Member());
	 * 
	 */
	@GetMapping("/add")
	public String addForm(@ModelAttribute("member")Member member) {
		
		return "members/addMemberForm";
	}
	
	//회원가입
	// /add, post 매핑
	// repository 회원 가입
	// home화면으로 
	
	@PostMapping("/add")
	public String save(@ModelAttribute Member member) {
	    memberRepository.save(member);
	    return "redirect:/";
	}
}

