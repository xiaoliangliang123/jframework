package com.framework.v1.business.sysUsers.dto;

import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;

import java.util.List;
import java.util.Map;

public class PermissionRoleManagerDTO {


    private  Sys_Perms_RoleModel sys_perms_roleModel;
    private  List<Map> allPermsGroupModels;
    private  List<String> rolePermsGroupModels;

    public PermissionRoleManagerDTO(Sys_Perms_RoleModel sys_perms_roleModel, List<String> rolePermsGroupModels, List<Map> allPermsGroupModels) {
        this.sys_perms_roleModel = sys_perms_roleModel;
        this.rolePermsGroupModels = rolePermsGroupModels;
        this.allPermsGroupModels = allPermsGroupModels;
    }

    public Sys_Perms_RoleModel getSys_perms_roleModel() {
        return sys_perms_roleModel;
    }

    public List<Map> getAllPermsGroupModels() {
        return allPermsGroupModels;
    }

    public List<String> getRolePermsGroupModels() {
        return rolePermsGroupModels;
    }
}
