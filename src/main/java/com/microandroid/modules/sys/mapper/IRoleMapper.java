package com.microandroid.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microandroid.modules.sys.dto.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户名得到角色信息
     *
     * @param username 用户名
     * @return
     */
    List<Role> selectRolesByUsername(@Param("username") String username);
}
