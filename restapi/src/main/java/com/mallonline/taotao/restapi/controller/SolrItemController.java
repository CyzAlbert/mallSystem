package com.mallonline.taotao.restapi.controller;

import com.mallonline.taotao.restapi.service.SolrItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mallonline.taotao.restapi.pojo.TaotaoResult;

@Controller
@RequestMapping("/manager")
public class SolrItemController {
	
	@Autowired
	private SolrItemService itemService;

	/**
	 * 导入商品数据到索引库
	 */
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAllItems() {
		TaotaoResult result = itemService.importAllItems();
		return result;
	}
}
