package com.qee.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzzhuqi1 on 2017/6/2.
 */
public class TokenFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
      /*  RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURI());
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("token is null");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("ok");
        return null;*/
        return null;
    }
}
