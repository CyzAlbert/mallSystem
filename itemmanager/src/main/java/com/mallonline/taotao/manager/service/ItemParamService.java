package com.mallonline.taotao.manager.service;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbItemParam;

public interface ItemParamService {
	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult inserItemParam(TbItemParam itemParam);
	EUIDataGrideResult getAllItemParam(int page, int rows);
}
