package com.mallonline.taotao.restapi.service;

import org.apache.solr.client.solrj.SolrQuery;

import com.mallonline.taotao.restapi.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
