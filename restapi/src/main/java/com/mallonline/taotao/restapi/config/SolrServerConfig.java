package com.mallonline.taotao.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

@Configuration
public class SolrServerConfig {

    @Value("${Solr.ServerUrl}")
    private String ServerUrl;

    @Bean
    public HttpSolrServer getSolrServer(){
        return new HttpSolrServer(this.ServerUrl);
    }

}
