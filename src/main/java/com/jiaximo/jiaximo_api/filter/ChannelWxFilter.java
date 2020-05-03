package com.jiaximo.jiaximo_api.filter;

import com.jiaximo.jiaximo_api.utils.EncryptionUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 过滤器
 * 判断请求是否来自微信
 */
@WebFilter(urlPatterns = "/*", filterName = "channelWxFilter")
@Slf4j
public class ChannelWxFilter implements Filter {

    @Value("${TOKEN}")
    String token;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter...");
        String signature = servletRequest.getParameter("signature");
        if(StringUtils.isEmpty(signature)){
            return;
        }
        String timestamp = servletRequest.getParameter("timestamp");
        if(StringUtils.isEmpty(timestamp)){
            return;
        }
        String nonce = servletRequest.getParameter("nonce");
        if(StringUtils.isEmpty(nonce)){
            return;
        }

        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add(token);
        tempArray.add(timestamp);
        tempArray.add(nonce);
        tempArray.sort(new Comparator<String>() {
            //将token、timestamp、nonce三个参数进行字典序排序
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tempArray.toString();

        //将三个参数字符串拼接成一个字符串进行sha1加密
        String tempStr = tempArray.toString().replace("[", "").replace("]", "").replaceAll(",", "");
        try {
            tempStr = EncryptionUtil.sha1(tempStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }

        //加密后的字符串可与signature对比
        if(!tempStr.equals(signature)){
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
