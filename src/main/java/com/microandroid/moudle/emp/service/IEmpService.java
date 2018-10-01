package com.microandroid.moudle.emp.service;

import com.microandroid.moudle.emp.bean.EmpForm;

import java.util.List;

public interface IEmpService<T extends EmpForm> {

    int deleteByPrimaryKey(Integer id) throws Exception;

    int inserts(List<T> ts) throws Exception;

    int insert(T record) throws Exception;

    int insertSelective(T record) throws Exception;

    T selectByPrimaryKey(Integer id) throws Exception;

    List<T> selectAll() throws Exception;

    int updateByPrimaryKeySelective(T record) throws Exception;

    int updateByPrimaryKey(T record) throws Exception;
}
