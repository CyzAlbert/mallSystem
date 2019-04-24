package com.mallonline.taotao.manager.mapper;


import com.mallonline.taotao.manager.entity.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbItemMapperTest {
    @Autowired
    private TbItemMapper mapper;

    @Test
    public void test(){
        long id=635906;
        TbItem item=mapper.selectByPrimaryKey(id);
        System.out.println(item.getTitle());
    }
}
