package cn.com.tjpower.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.tjpower.www.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService uerService;
	
	

}
