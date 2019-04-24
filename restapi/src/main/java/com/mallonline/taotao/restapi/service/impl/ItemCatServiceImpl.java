package com.mallonline.taotao.restapi.service.impl;

import com.mallonline.taotao.restapi.mapper.TbItemCatMapper;
import com.mallonline.taotao.restapi.entity.TbItemCat;
import com.mallonline.taotao.restapi.entity.TbItemCatExample;
import com.mallonline.taotao.restapi.entity.TbItemCatExample.Criteria;
import com.mallonline.taotao.restapi.pojo.CatNode;
import com.mallonline.taotao.restapi.pojo.CatResult;
import com.mallonline.taotao.restapi.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public CatResult getItemCatList() {
		// TODO Auto-generated method stub
		CatResult result=new CatResult();
		
		result.setData(getCatList(0));
		
		return result;
	}
	
 	private List<?> getCatList(long parentId){
 		TbItemCatExample example=new TbItemCatExample();
 		Criteria criteria=example.createCriteria();
 		criteria.andParentIdEqualTo(parentId);
 		
 		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		List resultList=new ArrayList<>();
 		
		int count=0;
 		for(TbItemCat item:list) {
 			if(item.getIsParent()) {
	 			CatNode catNode=new CatNode();
	 			if(parentId==0) {
	 				catNode.setName("<a href='/products/"+item.getId()+".html'>"+item.getName()+"</a>");
	 			}
	 			else {
	 				catNode.setName(item.getName());
	 			}
	 			catNode.setUrl("/products/"+item.getId()+".html");
	 			catNode.setItem(getCatList(item.getId()));
	 			resultList.add(catNode);
	 			count++;
	 			if(parentId==0&&count>=14)
	 				break;
 			}
 			else {
 				resultList.add("/products/"+item.getId()+".html|"+item.getName());
 			}
 		}
 		
 		return resultList;
 	}

}
