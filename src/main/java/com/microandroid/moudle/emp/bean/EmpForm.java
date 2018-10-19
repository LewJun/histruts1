package com.microandroid.moudle.emp.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
@Getter
@Setter
@ToString
public class EmpForm extends ActionForm {
    private static final long serialVersionUID = 242511355679756376L;

    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Integer deptno;
}
