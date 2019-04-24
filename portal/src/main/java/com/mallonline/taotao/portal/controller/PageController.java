package com.mallonline.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/register")
	public String showResister() {
		return "register";
	}
	
	@RequestMapping("/login")
	public String showLogin(String redirect, Model model) {
		model.addAttribute("redirect",redirect);
		return "login";
	}
}
