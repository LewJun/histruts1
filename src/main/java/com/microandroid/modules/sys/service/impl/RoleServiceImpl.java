package com.microandroid.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.sys.dto.Role;
import com.microandroid.modules.sys.mapper.IRoleMapper;
import com.microandroid.modules.sys.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, Role> implements IRoleService {
    @Override
    public List<Role> selectRolesByUsername(String username) {
        return baseMapper.selectRolesByUsername(username);
    }
}
