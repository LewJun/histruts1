package com.microandroid.moudle.emp.service.impl;

import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.service.IEmpService;

import java.util.List;

public class EmpServiceImpl implements IEmpService<EmpForm> {
    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return 0;
    }

    @Override
    public int inserts(List<EmpForm> empForms) throws Exception {
        return 0;
    }

    @Override
    public int insert(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public int insertSelective(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public EmpForm selectByPrimaryKey(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<EmpForm> selectAll() throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(EmpForm record) throws Exception {
        return 0;
    }
}
