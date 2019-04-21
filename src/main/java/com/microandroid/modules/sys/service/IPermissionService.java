package com.microandroid.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.microandroid.modules.sys.dto.Permission;

import java.util.List;

public interface IPermissionService extends IService<Permission> {
    /**
     * 根据用户名得到权限信息
     *
     * @param username 用户名
     * @return
     */
    List<Permission> selectPermissionsByUsername(String username);

    /**
     * 根据路径查找
     *
     * @param url 地址
     * @return
     */
    Permission selectByUrl(String url);

    Permission selectByIdAndUsername(int pid, String username);
}
