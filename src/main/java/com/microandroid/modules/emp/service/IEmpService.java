package com.microandroid.modules.emp.service;

import com.baomidou.mybatisplus.service.IService;
import com.microandroid.modules.emp.dto.Emp;

import java.io.Serializable;
import java.util.List;

public interface IEmpService extends IService<Emp> {

    /**
     * 查询其下属员工
     *
     * @param pk
     * @return
     */
    List<Emp> selectSubEmpByPrimaryKey(Serializable pk);
}
