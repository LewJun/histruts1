package com.microandroid.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microandroid.modules.sys.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
