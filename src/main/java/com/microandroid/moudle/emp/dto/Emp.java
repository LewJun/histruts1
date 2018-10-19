package com.microandroid.moudle.emp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author LewJun
 * @version v0.1 2018/10/18 19:34 LewJun Exp $$
 */
@Getter
@Setter
@ToString
public class Emp {
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Integer deptno;

    private List<Emp> empList;

}
