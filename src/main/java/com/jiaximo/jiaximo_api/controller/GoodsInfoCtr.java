package com.jiaximo.jiaximo_api.controller;

import com.jiaximo.jiaximo_api.Dispatcher.MsgDispatcher;
import com.jiaximo.jiaximo_api.utils.MessageUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * 接收微信公众号的消息
 * 进行商品信息查询（调用客服消息接口异步回复信息）
 */

@RestController
@RequestMapping("/goodsInfo")
public class GoodsInfoCtr {

    @PostMapping("/findGoods")
    public void findGoods(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            //格式化消息
            Map<String, String> map = MessageUtil.parseXml(request);

            //处理回复消息
            String msgrsp = MsgDispatcher.processMessage(map);

            PrintWriter out = response.getWriter();
            out.print(msgrsp);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
