package com.microandroid.moudle.emp.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.service.IEmpService;
import com.microandroid.moudle.emp.service.impl.EmpServiceImpl;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
public class EmpAction extends BaseAppAction {

    private IEmpService<EmpForm> empService;

    public EmpAction() {
        this.empService = new EmpServiceImpl();
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        LOGGER.info("{}", empService);
        EmpForm record = new EmpForm();
        int random = (int) (1 + Math.random() * 100);
        record.setEmpno(random);
        record.setEname("emp " + random);
        empService.insert(record);
        return mapping.findForward("saveSuccess");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("delete");
        LOGGER.info("{}", empService);
        String id = request.getParameter("id");
        empService.deleteByPrimaryKey(Integer.valueOf(id));
        return mapping.findForward("saveSuccess");
    }

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("index");
        LOGGER.info("{}", empService);
        List<EmpForm> empFormList = empService.selectAll();
        Collections.sort(empFormList, new Comparator<EmpForm>() {
            @Override
            public int compare(EmpForm o1, EmpForm o2) {
                return o1.getEmpno() - o2.getEmpno();
            }
        });
        LOGGER.info("{}", empFormList);
        request.setAttribute("empList", empFormList);
        return mapping.findForward("index");
    }
}
