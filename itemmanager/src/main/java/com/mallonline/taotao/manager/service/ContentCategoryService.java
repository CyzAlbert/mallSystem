package com.mallonline.taotao.manager.service;

import com.mallonline.taotao.manager.common.pojo.TaotaoResult;
import com.mallonline.taotao.manager.common.pojo.TreeNode;

import java.util.List;

public interface ContentCategoryService {
	List<TreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
	TaotaoResult deleteContentCategory(long parentId, long id);
}
