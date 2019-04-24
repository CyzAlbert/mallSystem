package com.mallonline.taotao.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/*
	 * 展示首页
	 */
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@RequestMapping(value="/")
	public String showindex() {
		return "index";
	}
	
	/*
	 * 展示后台页面
	 */
	@RequestMapping(value="/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
