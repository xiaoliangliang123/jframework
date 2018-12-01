package com.framework.v1.business.common.model;

import com.framework.v1.framework.database.base.BaseModel;

public class UserModel extends BaseModel {

    private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username ;
    private String password ;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}