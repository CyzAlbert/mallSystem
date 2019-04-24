package com.mallonline.taotao.restapi.service;

import com.mallonline.taotao.restapi.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String queryString, int page, int rows) throws Exception;
}
