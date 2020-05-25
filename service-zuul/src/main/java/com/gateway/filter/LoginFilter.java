package com.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * filter types: pre route post error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
     * the priority to run current filter
     * order: the smaller the higher priority
     * if 0 there is no extension at all
     * */
    @Override
    public int filterOrder() {
        return 10;
    }

    /*
     * true means to run this filter
     *
     * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
     * filter logic
     * by default is null, nothing to do
     * How to get request in zuul filter?
     * --> RequestContext
     * */

    @Override
    public Object run() throws ZuulException {
        //get token parameter from request, zuul context
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");

        if (StringUtils.isBlank(token)) {
            //won't redirect request
            context.setSendZuulResponse(false);
            //set return code
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //response message
            context.setResponseBody("request is getting error, unauthorized");
        }
        // nothing to do
        // let it(request) go
        return null;
    }
}

