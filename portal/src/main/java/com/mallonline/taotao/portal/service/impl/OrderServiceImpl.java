package com.mallonline.taotao.portal.service.impl;

import com.mallonline.taotao.portal.common.pojo.TaotaoResult;
import com.mallonline.taotao.portal.pojo.Order;
import com.mallonline.taotao.portal.service.OrderService;
import com.mallonline.taotao.portal.common.utils.HttpClientUtil;
import com.mallonline.taotao.portal.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		TaotaoResult taotaoResult = TaotaoResult.format(json);
		if (taotaoResult.getStatus() == 200) {
			Long orderId = (Long) taotaoResult.getData();
			return orderId.toString();
		}
		return "";
	}
}
