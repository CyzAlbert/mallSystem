package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.pojo.TreeNode;
import com.mallonline.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/item/cat")
public class ItemCatController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/list")
	public List<TreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") long parentId) {
		List<TreeNode> result= itemService.getCatList(parentId);
		return result;
	}
}
