package com.jiaximo.jiaximo_api.messageVo;

/**
 * @author gede
 * @version date：2019年5月23日 下午6:39:32
 * @description ：
 */
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}