package com.microandroid.modules.sys.dto;

public class RolePermission {
    private int id;

    private Role roleid;

    private Permission permissionid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    public Permission getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Permission permissionid) {
        this.permissionid = permissionid;
    }
}
