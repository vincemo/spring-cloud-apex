package com.zg.apex.zuul_server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;

/**
 * Created by mmmooo on 2018/11/15 23:54
 */
@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @SuppressWarnings("RedundantThrows")
    @Override
    public Object run() throws ZuulException {
        System.out.println("这是ErrorFilter！");
        //从RequestContext获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //从上下文获取HttpServletRequest
        HttpServletRequest request = ctx.getRequest();
        //对该请求禁止路由，也就是禁止访问下游服务
        ctx.setSendZuulResponse(false);
        //设定responseBody供PostFilter使用
        ctx.setResponseBody("{\"status\":500,\"message\":" + request.getRequestURI() + "\"请求错误\"}");
        //logic-is-success保存于上下文，作为下游Filter的执行开关
        ctx.set("logic-is-success", false);
        return null;
    }
}
