package com.mallonline.taotao.restapi.controller;

import com.mallonline.taotao.restapi.pojo.TaotaoResult;
import com.mallonline.taotao.restapi.pojo.Order;
import com.mallonline.taotao.restapi.service.OrderService;
import com.mallonline.taotao.restapi.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestOrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/create")
	public TaotaoResult createOrder(@RequestBody Order order) {
		try {
			TaotaoResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
