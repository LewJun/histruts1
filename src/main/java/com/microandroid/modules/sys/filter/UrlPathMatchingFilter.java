package com.microandroid.modules.sys.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlPathMatchingFilter extends PathMatchingFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlPathMatchingFilter.class);

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(req, resp, "/login.jsp");
            return false;
        }
//        String path = req.getServletPath()+req.getQueryString();
        // 如果当前路径地址不在权限表中，则表示不需要验证
//        if (! url not in permission) {
//            return true;
//        } else {
//            // 判断当前用户是否拥有对应的权限
//            return true;
//        }

//        默认返回true，表示路径都通过验证
        return true;
    }
}
