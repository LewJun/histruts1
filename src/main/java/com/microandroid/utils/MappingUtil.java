package com.microandroid.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microandroid.exception.GlobalException;
import com.microandroid.result.ApiResult;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MappingUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MappingUtil.class);

    public static ActionForward forward(ActionMapping mapping, String forwardName) {
        return mapping.findForward(forwardName);
    }

    /**
     * 渲染json数据
     *
     * @param response 响应
     * @param data     需要响应的数据
     * @return 使用response输出data json数据
     */
    public static ActionForward renderJson(HttpServletResponse response, Object data) {
        PrintWriter writer = null;
        try {
            response.setContentType("application/json;charset=utf-8");
            writer = response.getWriter();
            ApiResult<Object> apiResult = (data == null
                    ? new ApiResult<>()
                    : new ApiResult<>(data)
            );
            Gson gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .serializeNulls()
                    .create();
            String ret = gson.toJson(apiResult);
            LOGGER.info("ret:{}", ret);
            writer.write(ret);
        } catch (IOException e) {
            throw new GlobalException(e);
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        return null;
    }


    /**
     * 渲染json数据，不返回数据
     *
     * @param response 响应
     * @return 使用response json数据
     */
    public static ActionForward renderJson(HttpServletResponse response) {
        return renderJson(response, null);
    }
}
