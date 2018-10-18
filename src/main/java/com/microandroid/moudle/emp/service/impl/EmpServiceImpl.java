package com.microandroid.moudle.emp.service.impl;

import com.microandroid.moudle.emp.dto.Emp;
import com.microandroid.moudle.emp.mapper.IEmpMapper;
import com.microandroid.moudle.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService<Emp> {

    @Autowired
    IEmpMapper empMapper;

    @Override
    public int insert(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleteByPrimaryKey(Serializable pk) {
        return empMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int inserts(List<Emp> ts) {
        return empMapper.inserts(ts);
    }

    @Override
    public int insertSelective(Emp record) {
        return empMapper.insertSelective(record);
    }

    @Override
    public Emp selectByPrimaryKey(Serializable pk) {
        return empMapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk) {
        return empMapper.selectEmpWithSubEmpByPrimaryKey(pk);
    }
}
