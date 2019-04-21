package com.microandroid.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.sys.dto.Permission;
import com.microandroid.modules.sys.mapper.IPermissionMapper;
import com.microandroid.modules.sys.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<IPermissionMapper, Permission> implements IPermissionService {
    @Override
    public List<Permission> selectPermissionsByUsername(String username) {
        return baseMapper.selectPermissionsByUsername(username);
    }

    @Override
    public Permission selectByUrl(String url) {
        return baseMapper.selectByUrl(url);
    }

    @Override
    public Permission selectByIdAndUsername(int pid, String username) {
        return baseMapper.selectByIdAndUsername(pid, username);
    }
}
