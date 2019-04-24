package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.common.pojo.TreeNode;
import com.mallonline.taotao.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	
	@RequestMapping("/list")
	public List<TreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<TreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}

	@RequestMapping("/create")
	public TaotaoResult insertContentCategory(Long parentId, String name) {
		TaotaoResult result=contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/delete")
	public TaotaoResult dleteContentCategory(Long parentId, Long id) {
		TaotaoResult result=contentCategoryService.deleteContentCategory(parentId, id);
		return result;
	}


}
