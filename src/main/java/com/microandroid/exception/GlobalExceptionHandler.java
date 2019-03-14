package com.microandroid.exception;

import com.microandroid.utils.MappingUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 *
 * @author LewJun
 * @version v0.1 2019/03/14 16:57 LewJun Exp $$
 */
public class GlobalExceptionHandler extends ExceptionHandler {
    private static final Logger LOGGER    = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * ajax请求标志
     */
    private static final String AJAX_FLAG = "XMLHttpRequest";

    @Override
    public ActionForward execute(Exception ex,
                                 ExceptionConfig ae,
                                 ActionMapping mapping,
                                 ActionForm formInstance,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException {

        LOGGER.error("发生了异常", ex);
        String xReqWith = request.getHeader("X-Requested-With");
        // 如果是Ajax请求
        if (AJAX_FLAG.equals(xReqWith)) {

            return null;
        }

        request.setAttribute("err", ex.getMessage());
        return MappingUtil.forward(mapping, "global-error");
    }
}
