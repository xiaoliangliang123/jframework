package com.framework.v1.business.sysUsers.dto;

import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.framework.requestMapping.Permission;

import java.util.List;

public class PermissionGroupManagerDTO {

    private final Sys_Perms_GroupModel sysPermsGroupModel;
    private final List<Permission> permissions;
    private final List<String> urls;

    public PermissionGroupManagerDTO(Sys_Perms_GroupModel sysPermsGroupModel, List<Permission> permissions,List<String> urls) {
        this.sysPermsGroupModel = sysPermsGroupModel;
        this.permissions = permissions;
        this.urls = urls;

    }

    public List<String> getUrls() {
        return urls;
    }

    public Sys_Perms_GroupModel getSysPermsGroupModel() {
        return sysPermsGroupModel;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
