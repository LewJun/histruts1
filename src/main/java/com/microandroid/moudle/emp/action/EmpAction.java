package com.microandroid.moudle.emp.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.service.IEmpService;
import com.microandroid.moudle.emp.service.impl.EmpServiceImpl;
import com.microandroid.utils.MappingUtil;
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
        EmpForm record = (EmpForm) form;
        empService.insert(record);
        return MappingUtil.forward(mapping, "saveSuccess");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("delete");
        LOGGER.info("{}", empService);
        String empno = request.getParameter("empno");
        empService.deleteByPrimaryKey(Integer.valueOf(empno));
        return MappingUtil.forward(mapping, "saveSuccess");
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
        return MappingUtil.forward(mapping, "index");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("add");
        return MappingUtil.forward(mapping, "add");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("edit");
        String empno = request.getParameter("empno");
        EmpForm empForm = empService.selectByPrimaryKey(Integer.valueOf(empno));
        LOGGER.info("{}", empForm);
        request.setAttribute("emp", empForm);
        return MappingUtil.forward(mapping, "edit");
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("update");
        EmpForm record = (EmpForm) form;
        empService.updateByPrimaryKey(record);
        return MappingUtil.forward(mapping, "saveSuccess");
    }

}
