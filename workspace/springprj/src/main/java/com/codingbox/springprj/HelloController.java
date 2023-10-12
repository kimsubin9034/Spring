package com.codingbox.springprj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
	model.addAttribute("data" , "hello");
		return "hello";
	}
	
	/*
	 *	/hello
	 *	"data" : "hello"
	 *	return hello
	 *	화면 : 안녕하세요 , hello
	 */
	
	
}
