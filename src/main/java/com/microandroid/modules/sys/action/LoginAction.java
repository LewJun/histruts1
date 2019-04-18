package com.microandroid.modules.sys.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.modules.sys.form.LoginForm;
import com.microandroid.utils.MappingUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        LOGGER.info("login");
        LoginForm loginForm = (LoginForm) form;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                loginForm.getUsername(),
                loginForm.getPassword(),
                loginForm.isRememberMe()
        );

        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                Session session = subject.getSession();
                session.setAttribute("subject", subject);
            }
        } catch (Exception e) {
            LOGGER.error("出现异常：", e);
            return MappingUtil.forward(mapping, "login");
        }
        return MappingUtil.forward(mapping, "success");
    }

}
