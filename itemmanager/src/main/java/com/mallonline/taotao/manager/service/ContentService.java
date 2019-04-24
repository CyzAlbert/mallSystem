package com.mallonline.taotao.manager.service;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.entity.TbContent;

public interface ContentService {
	TaotaoResult insertContent(TbContent content);
	EUIDataGrideResult getContentList(Long categoryId, Integer page, Integer rows);
}
