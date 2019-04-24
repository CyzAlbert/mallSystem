package com.mallonline.taotao.portal.controller;

import com.mallonline.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/index")
	public String showIndex(Model model) {
		String contenJson=contentService.getContentList();
		model.addAttribute("ad1",contenJson);
		return "index";
	}
	
}
