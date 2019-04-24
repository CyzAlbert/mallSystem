package com.mallonline.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.common.pojo.TreeNode;
import com.mallonline.taotao.manager.common.utils.IDUtils;
import com.mallonline.taotao.manager.entity.*;
import com.mallonline.taotao.manager.entity.TbItemExample.Criteria;
import com.mallonline.taotao.manager.mapper.TbItemCatMapper;
import com.mallonline.taotao.manager.mapper.TbItemDescMapper;
import com.mallonline.taotao.manager.mapper.TbItemMapper;
import com.mallonline.taotao.manager.mapper.TbItemParamItemMapper;
import com.mallonline.taotao.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		
		TbItemExample example=new TbItemExample();
		
		Criteria ct=example.createCriteria();
		
		ct.andIdEqualTo(itemId);
		
		List<TbItem> list=itemMapper.selectByExample(example);
		
		if(list!=null && list.size()>0) {
			TbItem it=list.get(0);
			return it;
		}
		
		return null;
	}


	@Override
	public EUIDataGrideResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		TbItemExample example=new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list=itemMapper.selectByExample(example);
		EUIDataGrideResult result=new EUIDataGrideResult();
		PageInfo<TbItem> info=new PageInfo<>(list);
		result.setTotal(info.getTotal());
		result.setRows(list);
		return result;
	}


	@Override
	public List<TreeNode> getCatList(long parentId) {
		// TODO Auto-generated method stub
		TbItemCatExample example=new TbItemCatExample();
		
		//设置查询条件
		com.mallonline.taotao.manager.entity.TbItemCatExample.Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list= itemCatMapper.selectByExample(example);
		
		List<TreeNode> resultList=new ArrayList<>();
		
		for(TbItemCat catItem:list) {
			TreeNode node=new TreeNode(catItem.getId(),
										catItem.getName(),
										catItem.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}


	@Override
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
		// TODO Auto-generated method stub
		
		Long itemId=IDUtils.genItemId();
		
		item.setId(itemId);
		
		item.setStatus((byte)1);
		
		item.setCreated(new Date());
		
		item.setUpdated(new Date());
		
		itemMapper.insert(item);
		
		TaotaoResult result=insertItemDesc(itemId, desc);
				
		if(result.getStatus()!=200) {
			throw new Exception();
		}
		
		result=insertItemparamItem(itemId, itemParam);
		
		if(result.getStatus()!=200) {
			throw new Exception();
		}
	
		return TaotaoResult.ok();
	}
	
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		TbItemDesc itemDesc=new TbItemDesc();
		
		itemDesc.setCreated(new Date());
		itemDesc.setItemId(itemId);
		itemDesc.setUpdated(new Date());
		itemDesc.setItemDesc(desc);
		
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	
	private TaotaoResult insertItemparamItem(Long itemId, String itemParamItem) {
		TbItemParamItem res=new TbItemParamItem();
		res.setItemId(itemId);
		res.setParamData(itemParamItem);
		res.setCreated(new Date());
		res.setUpdated(new Date());
		itemParamItemMapper.insert(res);
		return TaotaoResult.ok();
	}

}
