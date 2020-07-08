package com.jiaximo.jiaximo_api.service;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemInfoGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaoBaoApiSer {

    @Autowired
    TaobaoClient taobaoClient;

    @Autowired
    TbkItemInfoGetRequest tbkItemInfoGetRequest;

    /**
     * 淘宝客商品详情查询
     * @param ids
     * @param platform
     * @param ip
     * @return
     * @throws ApiException
     */
    public TbkItemInfoGetResponse getTbkItemInfoGetResponse(String ids, long platform, String ip) throws ApiException {
        TbkItemInfoGetResponse response = new TbkItemInfoGetResponse();
        tbkItemInfoGetRequest.setNumIids(ids);
        tbkItemInfoGetRequest.setIp(ip);
        tbkItemInfoGetRequest.setPlatform(platform);
        response = taobaoClient.execute(tbkItemInfoGetRequest);
        return response;
    }

}
