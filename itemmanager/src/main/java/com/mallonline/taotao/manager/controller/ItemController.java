package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbItem;
import com.mallonline.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/{itemId}",method= RequestMethod.GET)
	public TbItem getTbItemById(@PathVariable Long itemId) {
		TbItem item=itemService.getItemById(itemId);
		
		return item;	
	}
	
	@RequestMapping(value="/item/list")
	public EUIDataGrideResult getItemList(Integer page, Integer rows) {
		EUIDataGrideResult dataGrideResult=itemService.getItemList(page, rows);
		
		return dataGrideResult;
	}
	
	@RequestMapping(value="/item/save",method= RequestMethod.POST)
	private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception{
		TaotaoResult result=itemService.createItem(item,desc,itemParams);
		return result;
	}
}
