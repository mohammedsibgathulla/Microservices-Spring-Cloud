package com.aistle.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulLoggingFilter extends ZuulFilter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean shouldFilter() {
		// Should Filter -> "true" or "false"
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// It gives the current httprequest which is handled.
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		// Filter Types -> "pre", "post" or "error"
		return "pre";
	}

	@Override
	public int filterOrder() {
		// if you have multiple filters like ZuulFilter,ZuulSecurityFilter you can give
		// priority
		return 1;
	}

}
