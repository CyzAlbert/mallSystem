package com.mallonline.taotao.restapi.service;

import com.mallonline.taotao.restapi.pojo.TaotaoResult;

public interface ItemService {
	TaotaoResult getItemBaseInfo(long itemId);
	TaotaoResult getItemDesc(long itemId);
	TaotaoResult getItemParam(long itemId);
}
