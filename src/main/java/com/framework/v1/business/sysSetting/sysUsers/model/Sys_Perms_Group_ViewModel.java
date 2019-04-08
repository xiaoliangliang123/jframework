package com.framework.v1.business.sysSetting.sysUsers.model;

import com.framework.v1.framework.database.base.BaseModel;

public class Sys_Perms_Group_ViewModel extends BaseModel {


    private String id;

    private String name;

    private String url ;

    private String groupId ;

    private String seq ;

    private String isNeedCheck ;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getIsNeedCheck() {
        return isNeedCheck;
    }

    public void setIsNeedCheck(String isNeedCheck) {
        this.isNeedCheck = isNeedCheck;
    }
}
