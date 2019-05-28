package com.vinspier.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class MyFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    // 拦截类型 请求前
    @Override
    public String filterType() {
        return "pre";
    }

    // 多个filter环境下 启动的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否开启此拦截功能
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 拦截具体实现的逻辑
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("request access url: " + request.getRequestURL().toString() + "    request method : " + request.getMethod());

        // 假设验证 accessToken的存在性
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null){
            logger.warn("warning: accessToken is not null here");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        logger.info("accessToken is verified OK");
        return null;
    }
}
