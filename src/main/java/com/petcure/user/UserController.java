package com.petcure.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@RequestMapping(path = "/")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping(path = "/list")
	public String show(Model model) {
		model.addAttribute("hello", "안녕? 여기는 홈화면이야");
		
		return "home";
	}
	
}