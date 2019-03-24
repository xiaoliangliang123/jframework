package com.framework.v1.business.sysSetting.sysUsers.dto;

import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_UserModel;

import java.util.List;

public class PermissionUserRolesManagerDTO {

    private Sys_UserModel sysUserModel;
    private List<Sys_Perms_RoleModel> allPermsRoleModels;
    private  List<String> userRolesIds;

    public PermissionUserRolesManagerDTO(Sys_UserModel sysUserModel, List<String> userRolesIds,List<Sys_Perms_RoleModel> allPermsRoleModels) {
        this.sysUserModel = sysUserModel;
        this.userRolesIds = userRolesIds;
        this.allPermsRoleModels = allPermsRoleModels;
    }

    public Sys_UserModel getSysUserModel() {
        return sysUserModel;
    }

    public List<Sys_Perms_RoleModel> getAllPermsRoleModels() {
        return allPermsRoleModels;
    }

    public List<String> getUserRolesIds() {
        return userRolesIds;
    }
}
