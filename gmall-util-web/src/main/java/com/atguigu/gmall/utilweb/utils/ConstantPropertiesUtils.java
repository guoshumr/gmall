package com.atguigu.gmall.utilweb.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author goolearn
 * @date 2019/9/9 0:54
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {
    @Value("${fileServer.url}")
    private String serverUrl;

    static String SERVER_URL;

    @Override
    public void afterPropertiesSet() {
        SERVER_URL = serverUrl;
    }



}
