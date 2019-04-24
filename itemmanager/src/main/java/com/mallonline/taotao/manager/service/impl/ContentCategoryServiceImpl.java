package com.mallonline.taotao.manager.service.impl;

import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.common.pojo.TreeNode;
import com.mallonline.taotao.manager.entity.TbContentCategory;
import com.mallonline.taotao.manager.entity.TbContentCategoryExample;
import com.mallonline.taotao.manager.entity.TbContentCategoryExample.Criteria;
import com.mallonline.taotao.manager.mapper.TbContentCategoryMapper;
import com.mallonline.taotao.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<TreeNode> getCategoryList(long parentId) {
		
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbContentCategory> list=contentCategoryMapper.selectByExample(example);
		List<TreeNode> resultList=new ArrayList<>();
		for(TbContentCategory item:list) {
			TreeNode node=new TreeNode();
			node.setId(item.getId());
			node.setText(item.getName());
			node.setState(item.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult deleteContentCategory(long parentId, long id) {
		// TODO Auto-generated method stub
		
		contentCategoryMapper.deleteByPrimaryKey(id);
		
		TbContentCategoryExample example=new TbContentCategoryExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andParentIdEqualTo(parentId);
				
		List<TbContentCategory> result=contentCategoryMapper.selectByExample(example);
		
		if(result.size()==0) {
			TbContentCategory record=contentCategoryMapper.selectByPrimaryKey(parentId);
			record.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKey(record);
		}
		
		return TaotaoResult.ok();
	}

}
