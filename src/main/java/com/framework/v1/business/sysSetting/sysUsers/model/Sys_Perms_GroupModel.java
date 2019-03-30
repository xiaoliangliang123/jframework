package com.framework.v1.business.sysSetting.sysUsers.model;

import com.framework.v1.framework.database.base.BaseModel;

public class Sys_Perms_GroupModel extends BaseModel {

    private String uid;
    private String id ;
    private String name ;
    private String isTop;
    private String parentId;

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
