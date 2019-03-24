package com.framework.v1.business.sysSetting.sysUsers.model;

import com.framework.v1.framework.database.base.BaseModel;

public class Sys_Perms_RoleModel  extends BaseModel {

    private String id;
    private String role_id ;
    private String role_name ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}