package com.mallonline.taotao.portal.service;

import com.mallonline.taotao.portal.pojo.Item;

public interface ItemService {
	Item getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParam(Long itemId);
}
