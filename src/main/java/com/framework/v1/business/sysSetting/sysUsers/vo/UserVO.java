package com.framework.v1.business.sysSetting.sysUsers.vo;

import com.framework.v1.business.sysSetting.sysUsers.model.Sys_UserModel;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.Role;

import java.util.List;

public class UserVO {

    private Sys_UserModel sysUserModel;
    List<Permission> permissions ;
    List<Role> roles;

    public UserVO(Sys_UserModel sysUserModel, List<Permission> permissions,List<Role> roles ) {
        this.sysUserModel = sysUserModel;
        this.permissions = permissions;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Sys_UserModel getSysUserModel() {
        return sysUserModel;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public Boolean hasPermissionForParh(String requestPath) {
        return  Permission.hasUrl(requestPath,permissions);
    }

    public boolean hasRoleOf(String roleId) {
        return Role.hasRoleIdOf(roleId,roles);
    }
}
