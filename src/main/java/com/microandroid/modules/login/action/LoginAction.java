package com.microandroid.modules.login.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.utils.MappingUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LewJun
 * @version v0.1 2019/03/29 10:19 LewJun Exp $$
 */
@Controller("/loginAction")
public class LoginAction extends BaseAppAction {

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        LOGGER.info("index");
        return MappingUtil.forward(mapping, "index");
    }

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        LOGGER.info("login");
        return MappingUtil.forward(mapping, "success");
    }

    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        LOGGER.info("logout");
        return MappingUtil.forward(mapping, "logout");
    }

}
