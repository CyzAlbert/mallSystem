package com.mallonline.taotao.manager.service;

import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.common.pojo.TreeNode;
import com.mallonline.taotao.manager.entity.TbItem;

import java.util.List;

public interface ItemService {
	TbItem getItemById(long itemId);
	EUIDataGrideResult getItemList(int page, int rows);
	List<TreeNode> getCatList(long parentId);
	TaotaoResult createItem(TbItem item, String desc, String itemParamData) throws Exception;
}
