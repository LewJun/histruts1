package com.microandroid.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 请求日志过滤器
 */
public class ReqlogFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqlogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("init");
        Enumeration initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String initParameterName = (String) initParameterNames.nextElement();
            LOGGER.info("{}: {}", initParameterName, filterConfig.getInitParameter(initParameterName));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("doFilter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        StringBuilder cookieStr = new StringBuilder("cookie:");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookieStr.append(String.format("%s %s %s %d %n", cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getMaxAge()));
        }
        LOGGER.info(cookieStr.toString());

        StringBuilder headerInfo = new StringBuilder();
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            headerInfo.append(String.format("%s:%s%n", headerName, req.getHeader(headerName)));
        }
        LOGGER.info(headerInfo.toString());


        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        LOGGER.info("destroy");
    }
}
