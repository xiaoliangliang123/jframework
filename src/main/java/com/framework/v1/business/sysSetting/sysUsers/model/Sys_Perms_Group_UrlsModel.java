package com.framework.v1.business.sysSetting.sysUsers.model;

import com.framework.v1.framework.database.base.BaseModel;

public class Sys_Perms_Group_UrlsModel extends BaseModel {


    private String id;
    private String perms_group_id;
    private String perms_group_url ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerms_group_id() {
        return perms_group_id;
    }

    public void setPerms_group_id(String perms_group_id) {
        this.perms_group_id = perms_group_id;
    }

    public String getPerms_group_url() {
        return perms_group_url;
    }

    public void setPerms_group_url(String perms_group_url) {
        this.perms_group_url = perms_group_url;
    }
}
