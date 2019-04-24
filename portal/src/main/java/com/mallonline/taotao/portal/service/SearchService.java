package com.mallonline.taotao.portal.service;

import com.mallonline.taotao.portal.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String queryString, int page);
}
