package com.mallonline.taotao.restapi.service;

import com.mallonline.taotao.restapi.pojo.TaotaoResult;
import com.mallonline.taotao.restapi.entity.TbOrder;
import com.mallonline.taotao.restapi.entity.TbOrderItem;
import com.mallonline.taotao.restapi.entity.TbOrderShipping;

import java.util.List;

public interface OrderService {
	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
