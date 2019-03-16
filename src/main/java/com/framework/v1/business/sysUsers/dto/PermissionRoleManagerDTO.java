package com.framework.v1.business.sysUsers.dto;

import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysUsers.vo.SysPermsGroupUrlVO;

import java.util.List;
import java.util.Map;

public class PermissionRoleManagerDTO {


    private  Sys_Perms_RoleModel sys_perms_roleModel;
    private  Map<String, List<SysPermsGroupUrlVO>> allPermsGroupModels;
    private  List<String> rolePermsGroupUrls;

    public PermissionRoleManagerDTO(Sys_Perms_RoleModel sys_perms_roleModel, List<String> rolePermsGroupModels,Map<String, List<SysPermsGroupUrlVO>> allPermsGroupModels) {
        this.sys_perms_roleModel = sys_perms_roleModel;
        this.rolePermsGroupUrls = rolePermsGroupModels;
        this.allPermsGroupModels = allPermsGroupModels;
    }

    public Sys_Perms_RoleModel getSys_perms_roleModel() {
        return sys_perms_roleModel;
    }

    public Map<String, List<SysPermsGroupUrlVO>> getAllPermsGroupModels() {
        return allPermsGroupModels;
    }

    public List<String> getRolePermsGroupUrls() {
        return rolePermsGroupUrls;
    }
}
