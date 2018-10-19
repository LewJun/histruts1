package com.microandroid.moudle.emp.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.dto.Emp;
import com.microandroid.moudle.emp.service.IEmpService;
import com.microandroid.utils.MappingUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
@Controller("/empAction")
public class EmpAction extends BaseAppAction {

    @Autowired
    private IEmpService<Emp> empService;

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        LOGGER.info("{}", empService);
        EmpForm empForm = (EmpForm) form;
        Emp emp = new Emp();
        BeanUtils.copyProperties(empForm, emp);
        empService.insert(emp);
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
        List<Emp> empList = empService.selectAll();
        LOGGER.info("{}", empList);
        request.setAttribute("empList", empList);
        return MappingUtil.forward(mapping, "index");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("add");
        return MappingUtil.forward(mapping, "add");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("edit");
        String empno = request.getParameter("empno");
        Emp emp = empService.selectByPrimaryKey(Integer.valueOf(empno));
        LOGGER.info("{}", emp);
        request.setAttribute("emp", emp);
        return MappingUtil.forward(mapping, "edit");
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("update");
        EmpForm empForm = (EmpForm) form;
        Emp emp = new Emp();
        BeanUtils.copyProperties(empForm, emp);
        empService.updateByPrimaryKey(emp);
        return MappingUtil.forward(mapping, "saveSuccess");
    }

}
