package com.jiaximo.jiaximo_api.messageVo;

/**
 * @author gede
 * @version date：2019年5月23日 下午6:38:50
 * @description ：
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}