package com.mallonline.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbItemParam;
import com.mallonline.taotao.manager.entity.TbItemParamExample;
import com.mallonline.taotao.manager.entity.TbItemParamExample.Criteria;
import com.mallonline.taotao.manager.mapper.TbItemParamMapper;
import com.mallonline.taotao.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		// TODO Auto-generated method stub
		TbItemParamExample example=new TbItemParamExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andItemCatIdEqualTo(cid);
		
		List<TbItemParam> list=itemParamMapper.selectByExampleWithBLOBs(example);
		
		if(list!=null && list.size()>0) {
			return TaotaoResult.ok(list.get(0));
		}
		
		return TaotaoResult.ok();
	}


	@Override
	public TaotaoResult inserItemParam(TbItemParam itemParam) {
		// TODO Auto-generated method stub
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

	@Override
	public EUIDataGrideResult getAllItemParam(int page, int rows) {
		TbItemParamExample example=new TbItemParamExample();
		PageHelper.startPage(page,rows);
		List<TbItemParam> itemParamsList= itemParamMapper.selectByExample(example);
		PageInfo<TbItemParam> info=new PageInfo<>(itemParamsList);
		EUIDataGrideResult res=new EUIDataGrideResult();
		res.setRows(itemParamsList);
		res.setTotal(info.getTotal());
		return res;
	}

}
