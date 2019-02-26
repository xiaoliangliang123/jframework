package com.framework.v1.business.sysUsers.dto;

import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.framework.requestMapping.Permission;

import java.util.List;

public class PermissionGroupManagerDTO {

    private final Sys_Perms_GroupModel sysPermsGroupModel;
    private final List<Permission> permissions;

    public PermissionGroupManagerDTO(Sys_Perms_GroupModel sysPermsGroupModel, List<Permission> permissions) {
        this.sysPermsGroupModel = sysPermsGroupModel;
        this.permissions = permissions;
    }


    public Sys_Perms_GroupModel getSysPermsGroupModel() {
        return sysPermsGroupModel;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
