package com.mallonline.taotao.restapi.service;

import com.mallonline.taotao.restapi.entity.TbContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceImplTest {

    @Autowired
    private ContentService service;

    @Test
    public void test(){
        List<TbContent> res=service.getContentList(92);

        System.out.println(res.get(0).getTitle());
    }
}
