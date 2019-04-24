package com.mallonline.taotao.portal.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test(){
        MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("index");
        try {
            MvcResult res= mockMvc.perform(request).andReturn();
            System.out.println(res.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
