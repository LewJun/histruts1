package com.microandroid.modules.emp.action;

import com.microandroid.base.BaseAppAction;
import com.microandroid.cache.redis.RedisCacheManager;
import com.microandroid.exception.GlobalException;
import com.microandroid.modules.emp.dto.Emp;
import com.microandroid.modules.emp.form.EmpForm;
import com.microandroid.modules.emp.service.IEmpService;
import com.microandroid.result.ServiceStatus;
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
    private IEmpService empService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 得到form
     */
    private EmpForm getForm(ActionForm form) {
        return (EmpForm) form;
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        Emp emp = new Emp();
        BeanUtils.copyProperties(getForm(form), emp);
        empService.insert(emp);
        return MappingUtil.forward(mapping, "saveSuccess");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("delete");
        Integer empno = Integer.valueOf(request.getParameter("empno"));
        List<Emp> emps = empService.selectSubEmpByPrimaryKey(empno);
        if (emps != null && emps.size() > 0) {
            throw new GlobalException("存在下属成员，不允许删除。");
        }

        return MappingUtil.renderJson(response, empService.deleteById(empno));
    }

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("index");
        List<Emp> empList = empService.selectList(null);
        LOGGER.info("{}", empList);
        LOGGER.info("read from redis {}", redisCacheManager.hasKey("key"));
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
        Emp emp = empService.selectById(empno);
        LOGGER.info("{}", emp);
        request.setAttribute("emp", emp);
        return MappingUtil.forward(mapping, "edit");
    }

    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("update");
        Emp emp = new Emp();
        BeanUtils.copyProperties(getForm(form), emp);
        empService.updateById(emp);
        return MappingUtil.renderJson(response);
    }

    /**
     * 模拟发生一个异常
     */
    public ActionForward mockException(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        LOGGER.info("mockException");

        throw new GlobalException(ServiceStatus.FAILED);
    }

    /**
     * 返回数据
     */
    public ActionForward getEmpList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("getEmpList");

        return MappingUtil.renderJson(response, empService.selectList(null));
    }

}
