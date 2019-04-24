package com.mallonline.taotao.restapi.controller;

import com.mallonline.taotao.restapi.pojo.CatResult;
import com.mallonline.taotao.restapi.utils.JsonUtils;
import com.mallonline.taotao.restapi.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	
	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public String getItemCatList(String callback) {
		CatResult result=itemCatService.getItemCatList();

		String json= JsonUtils.objectToJson(result);
		String retunRes=callback+"("+json+");";
		return retunRes;
	}
	
}
