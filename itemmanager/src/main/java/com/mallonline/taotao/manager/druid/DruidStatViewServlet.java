package com.mallonline.taotao.manager.druid;


import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*",
initParams = {
        //用户名
        @WebInitParam(name="loginUsername",value = "chris"),
        //密码
        @WebInitParam(name="loginPassword",value = "chris"),
        // 禁用HTML页面上的“Reset All”功能
        @WebInitParam(name="resetEnable",value="false")
})
public class DruidStatViewServlet {
}
