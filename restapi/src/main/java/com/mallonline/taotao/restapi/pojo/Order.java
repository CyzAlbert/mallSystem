package com.mallonline.taotao.restapi.pojo;

import com.mallonline.taotao.restapi.entity.TbOrder;
import com.mallonline.taotao.restapi.entity.TbOrderItem;
import com.mallonline.taotao.restapi.entity.TbOrderShipping;

import java.util.List;

public class Order extends TbOrder{
	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
}
