package com.mallonline.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbContent;
import com.mallonline.taotao.manager.entity.TbContentExample;
import com.mallonline.taotao.manager.mapper.TbContentMapper;
import com.mallonline.taotao.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public TaotaoResult insertContent(TbContent content) {
		// TODO Auto-generated method stub
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		return TaotaoResult.ok();
	}

	@Override
	public EUIDataGrideResult getContentList(Long categoryId, Integer page, Integer rows) {
		TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(page,rows);
        List<TbContent> tbContents = contentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo=new PageInfo<>(tbContents);
        EUIDataGrideResult res=new EUIDataGrideResult();
        res.setTotal(pageInfo.getTotal());
        res.setRows(tbContents);
        return res;
	}

}
