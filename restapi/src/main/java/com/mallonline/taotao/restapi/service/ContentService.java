package com.mallonline.taotao.restapi.service;

import com.mallonline.taotao.restapi.entity.TbContent;

import java.util.List;


public interface ContentService {
	List<TbContent> getContentList(long contentCid);
}
