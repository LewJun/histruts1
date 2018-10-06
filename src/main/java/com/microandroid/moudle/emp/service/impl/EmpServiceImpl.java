package com.microandroid.moudle.emp.service.impl;

import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.service.IEmpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpServiceImpl implements IEmpService<EmpForm> {

    private Map<Integer, EmpForm> repositories = new HashMap<>();

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        repositories.remove(id);
        return repositories.size();
    }

    @Override
    public int inserts(List<EmpForm> empForms) throws Exception {
        for (EmpForm empForm : empForms) {
            repositories.put(empForm.getEmpno(), empForm);
        }
        return repositories.size();
    }

    @Override
    public int insert(EmpForm record) throws Exception {
        repositories.put(record.getEmpno(), record);
        return repositories.size();
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
        List<EmpForm> empForms = new ArrayList<>();
        for (Map.Entry<Integer, EmpForm> me : repositories.entrySet()) {
            empForms.add(me.getValue());
        }
        return empForms;
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
