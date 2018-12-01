package com.framework.v1.framework.requestMapping;


import java.util.List;

public class RequestMappingUtil {

    private List<Permission> permissions ;

    public RequestMappingUtil(){}

    public RequestMappingUtil(List<Permission> permissions) {
        permissions = permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
