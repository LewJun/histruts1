package com.microandroid.moudle.emp.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
public class EmpAction extends Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("execute");
        String method = request.getParameter("method");
        String forwardName = "success";
        if ("save".equals(method)) {
            forwardName = save(mapping, form, request, response).getName();
        }
        LOGGER.info(forwardName);
        return mapping.findForward(forwardName);
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        return mapping.findForward("save");
    }


}
