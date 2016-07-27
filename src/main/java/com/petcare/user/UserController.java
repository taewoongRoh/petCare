package com.petcare.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	
	@RequestMapping(path = "/")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping(path = "/test")
	public int show(Model model) {
		UserDTO dto = userMapper.findAll();
		
		return dto.getId();
	}
	
}