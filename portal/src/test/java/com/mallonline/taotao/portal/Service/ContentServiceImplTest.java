package com.mallonline.taotao.portal.Service;

import com.mallonline.taotao.portal.service.impl.ContentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceImplTest {

    @Autowired
    private ContentServiceImpl contentService;

    @Test
    public void test(){
        String contenJson=contentService.getContentList();
        System.out.println(contenJson);
    }
}
