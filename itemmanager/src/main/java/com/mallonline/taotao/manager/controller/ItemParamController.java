package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbItemParam;
import com.mallonline.taotao.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
 * 商品规格参数模板的操作
 * 
 */


@RestController
@RequestMapping(value="/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService service;
	
	@RequestMapping(value="/query/itemcatid/{itemcatId}")
	public TaotaoResult getItemParamByCid(@PathVariable Long itemcatId) {
		TaotaoResult result=service.getItemParamByCid(itemcatId);
		return result;
	}
	
	/*
	 *添加商品规格参数模板
	 */
	
	@RequestMapping(value="/save/{cid}")
	public TaotaoResult insertItemParam(@PathVariable(value="cid") Long cid, String paramData) {
		TbItemParam itemParam=new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result=service.inserItemParam(itemParam);
		return result;
	}

	@GetMapping(value = "/list")
	public EUIDataGrideResult getItemList(@RequestParam Integer page, @RequestParam Integer rows){
		EUIDataGrideResult res=service.getAllItemParam(page,rows);
		return res;
	}
}
