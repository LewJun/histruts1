package com.microandroid.modules.emp.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.emp.dto.Emp;
import com.microandroid.modules.emp.mapper.IEmpMapper;
import com.microandroid.modules.emp.service.IEmpService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<IEmpMapper, Emp> implements IEmpService {

    @Cacheable(cacheNames = "cache_emp", key = "#root.methodName.concat('#').concat(#pk)", unless = "#result == null")
    @Override
    public List<Emp> selectSubEmpByPrimaryKey(Serializable pk) {
        return baseMapper.selectSubEmpByPrimaryKey(pk);
    }

    @Cacheable(cacheNames = "cache_emp", key = "#id.toString()", unless = "#result == null")
    @Override
    public Emp selectById(Serializable id) {
        return super.selectById(id);
    }

    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "cache_emp", key = "'selectList#all'"),
                    @CacheEvict(cacheNames = "cache_emp", key = "'selectSubEmpByPrimaryKey#'.concat(#entity.empno.toString())")
            },
            put = {
                    @CachePut(cacheNames = "cache_emp", key = "#entity.empno.toString()", unless = "#result == false")
            }
    )
    @Override
    public boolean updateById(Emp entity) {
        return super.updateById(entity);
    }

    /**
     * 如果要实现删除多个，可以<pre>@CacheEvicts(keys={"key1", "key2", "key*"})</pre>，然后单独写aop来处理@Pointcut(value = "(execution(* *.*(..)) && @annotation(CacheEvicts))")
     *
     * @param id
     * @return
     */
//    @CacheEvict(cacheNames = "cache_emp", allEntries = true)
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "cache_emp", key = "#id.toString()"),
                    @CacheEvict(cacheNames = "cache_emp", key = "'selectList#all'"),
                    @CacheEvict(cacheNames = "cache_emp", key = "'selectSubEmpByPrimaryKey#'.concat(#id.toString())")
            }
    )
    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    @Cacheable(cacheNames = "cache_emp",
            key = "#root.methodName.concat('#all')",
            unless = "#result == null || #result.size() == 0")
    @Override
    public List<Emp> selectList() {
        return super.selectList(null);
    }
}

// redis做的缓存报错java.lang.Integer cannot be cast to java.lang.String
// redis中所有键都是字符串对象，字符串对象可以是能够用long类型保存的整数值。
// 如何理解这个问题：字符串和整数不在同一个对象结构中。redis中不能将Integer强制转化为String类型。转化为字符串必须通过String.valueOf(integer) 或者Integer.toString(integer)或者Integer.toString()
