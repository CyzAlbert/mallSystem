package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbContent;
import com.mallonline.taotao.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	public TaotaoResult inserContent(TbContent content) {
		TaotaoResult result=contentService.insertContent(content);
		return result;
	}

	@GetMapping("/query/list")
	public EUIDataGrideResult getContentList(@RequestParam Long categoryId,
											 @RequestParam Integer page,
											 @RequestParam Integer rows){
		return contentService.getContentList(categoryId,page,rows);
	}
}
