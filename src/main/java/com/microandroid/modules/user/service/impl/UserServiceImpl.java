package com.microandroid.modules.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.user.dto.User;
import com.microandroid.modules.user.mapper.IUserMapper;
import com.microandroid.modules.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Override
    public User selectByUsername(String username) {
        return baseMapper.selectByUsername(username);
    }
}
