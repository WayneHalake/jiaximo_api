package com.jiaximo.jiaximo_api.config;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemInfoGetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope
public class TaobaoApiConfig {

    @Value("${TAOBAOLM.APPKEY}")
    private String appkey;

    @Value("${TAOBAOLM.APPSECRET}")
    private String appSecret;

    @Value("${TAOBAOLM.URL}")
    private String url;

    //初始化taobaoClient
    @Bean("taobaoClient")
    private TaobaoClient initTaoBaoClient(){
        return new DefaultTaobaoClient(url, appkey, appSecret);
    }

    @Bean("tbkItemInfoGetRequest")
    private TbkItemInfoGetRequest initTbkItemInfoGetRequest(){
        return new TbkItemInfoGetRequest();
    }


}
