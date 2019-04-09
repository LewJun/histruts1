package com.microandroid.modules.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.microandroid.modules.user.dto.User;

public interface IUserService extends IService<User> {
    /**
     * 根据用户名查找
     *
     * @param username 用户名
     * @return
     */
    User selectByUsername(String username);
}
