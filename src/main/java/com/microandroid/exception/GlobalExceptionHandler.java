package com.microandroid.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microandroid.result.ApiResult;
import com.microandroid.result.ServiceStatus;
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
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常处理器
 *
 * @author LewJun
 * @version v0.1 2019/03/14 16:57 LewJun Exp $$
 */
public class GlobalExceptionHandler extends ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
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
        String ret = ex.getMessage();
        ApiResult apiResult = new ApiResult(ServiceStatus.EXCEPTION);
        if (ex instanceof GlobalException) {
            GlobalException ge = (GlobalException) ex;
            apiResult = ge.getResult();
            ServiceStatus status = apiResult.getStatus();
            if (status != null) ret = status.getMsg();
        }

        String xReqWith = request.getHeader("X-Requested-With");
        // 如果是Ajax请求
        if (AJAX_FLAG.equals(xReqWith)) {
            PrintWriter writer = null;
            try {
                Gson gson = new GsonBuilder()
                        .disableHtmlEscaping()
                        .create();
                ret = gson.toJson(apiResult);
                LOGGER.info("ret:{}", ret);
                response.setContentType("application/json;charset=utf-8");
                writer = response.getWriter();
                writer.write(ret);
            } catch (IOException e) {
                LOGGER.error("发生了异常", e);
            } finally {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            }
            return null;
        } else {
            request.setAttribute("err", ret);
            return super.execute(ex, ae, mapping, formInstance, request, response);
        }
    }
}
