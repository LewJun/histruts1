package com.microandroid.modules.login.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.modules.login.form.LoginForm;
import com.microandroid.utils.MappingUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LewJun
 * @version v0.1 2019/03/29 10:19 LewJun Exp $$
 */
@Controller("/loginAction")
public class LoginAction extends BaseAppAction {

    /**
     * 登录
     */
    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        LOGGER.info("login");
        HttpSession session = request.getSession();
        LoginForm loginForm = (LoginForm) form;
        session.setAttribute("loginUser", loginForm);
        return MappingUtil.forward(mapping, "success");
    }

    /**
     * 退出
     */
    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        LOGGER.info("logout");
        HttpSession session = request.getSession();
        session.invalidate();
        return MappingUtil.forward(mapping, "login");
    }

}
