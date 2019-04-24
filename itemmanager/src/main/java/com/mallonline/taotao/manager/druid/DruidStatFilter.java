package com.mallonline.taotao.manager.druid;


import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName ="druidWebStatFilter",urlPatterns = "/*",
        initParams = {
        @WebInitParam(name="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*",value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
})
public class DruidStatFilter {
}
