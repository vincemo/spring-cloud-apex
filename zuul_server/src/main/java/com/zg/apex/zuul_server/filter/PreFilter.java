package com.zg.apex.zuul_server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Created by mmmooo on 2018/11/16 00:03
 */
@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
       return true;
    }

    @SuppressWarnings("RedundantThrows")
    @Override
    public Object run() throws ZuulException {
        System.out.println("这是PreZuulFilter！");
        return null;
    }
}
