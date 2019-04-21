package com.microandroid.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.microandroid.modules.sys.dto.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {
    /**
     * 根据用户名得到角色信息
     *
     * @param username 用户名
     * @return
     */
    List<Role> selectRolesByUsername(String username);
}
