package com.jiaximo.jiaximo_api.Dispatcher;

import com.jiaximo.jiaximo_api.messageVo.TextMessage;
import com.jiaximo.jiaximo_api.utils.MessageUtil;

import java.util.Date;
import java.util.Map;


/**
 * @author gede
 * @version date：2019年5月23日 下午6:49:11
 * @description ：
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {
        String openid=map.get("FromUserName"); //用户openid
        String mpid=map.get("ToUserName");   //公众号原始ID
        //普通文本消息
        TextMessage txtmsg=new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            txtmsg.setContent("你好，欢迎您的关注！");
            return MessageUtil.textMessageToXml(txtmsg);
        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return null;
    }
}