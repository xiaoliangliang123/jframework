package com.framework.v1.framework.requestMapping;

import java.io.Serializable;

public class UserRole implements Serializable {

    private int id;

    private String userId;

    private String roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserRole() {
    }

    public UserRole(String userId, String roleId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
