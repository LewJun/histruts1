package com.microandroid.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microandroid.modules.sys.dto.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户名得到权限信息
     *
     * @param username 用户名
     * @return
     */
    List<Permission> selectPermissionsByUsername(@Param("username") String username);

    /**
     * 根据路径查找
     *
     * @param url 路径
     * @return
     */
    Permission selectByUrl(String url);

    /**
     * 根据权限ID和用户名查找
     *
     * @param pid      权限ID
     * @param username 用户名
     * @return
     */
    Permission selectByIdAndUsername(@Param("pid") int pid, @Param("username") String username);
}
