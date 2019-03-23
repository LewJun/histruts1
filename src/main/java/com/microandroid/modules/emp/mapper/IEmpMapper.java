package com.microandroid.modules.emp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microandroid.modules.emp.dto.Emp;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IEmpMapper extends BaseMapper<Emp> {

    /**
     * 查询其下属员工
     *
     * @param pk 主键
     * @return
     */
    List<Emp> selectSubEmpByPrimaryKey(Serializable pk);
}
