package com.mallonline.taotao.manager.controller;


import com.mallonline.taotao.manager.common.pojo.EUIDataGrideResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemParamControllerTest {

    @Autowired
    private ItemParamController controller;

    @Test
    public void test(){
        EUIDataGrideResult itemList = controller.getItemList(1, 2);
        System.out.println(itemList.getTotal());
    }

}
