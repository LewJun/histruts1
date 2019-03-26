package com.microandroid.modules.emp.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.emp.dto.Emp;
import com.microandroid.modules.emp.mapper.IEmpMapper;
import com.microandroid.modules.emp.service.IEmpService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<IEmpMapper, Emp> implements IEmpService {

    @Override
    public List<Emp> selectSubEmpByPrimaryKey(Serializable pk) {
        return baseMapper.selectSubEmpByPrimaryKey(pk);
    }

    @Cacheable(value = "cache_emp", key = "#id")
    @Override
    public Emp selectById(Serializable id) {
        return super.selectById(id);
    }
}
