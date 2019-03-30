package com.microandroid.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 登录过滤器
 */
public class LoginFilter implements Filter {
    private List<String> exclusions;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String exclusionsStr = filterConfig.getInitParameter("exclusions");
        this.exclusions = exclusionsStr != null ? Arrays.asList(exclusionsStr.split(",")) : null;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (exclusions != null && exclusions.size() > 0) {
            String servletPath = req.getServletPath();
            if (!exclusions.contains(servletPath)) {
                // 得到session，如果没有则不要创建，默认是true创建
                HttpSession session = req.getSession();

                if (session == null || session.getAttribute("loginUser") == null) {
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                    return;
                }
            }
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
