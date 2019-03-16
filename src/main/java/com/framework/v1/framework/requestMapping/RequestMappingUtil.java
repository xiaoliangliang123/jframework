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

    public Permission getPermissionForUrl(String url) throws NoSuchFieldException {
        for(Permission perm:permissions){
            if(perm.urlIs(url)){
                return perm;
            }
        }
        throw  new NoSuchFieldException("url:"+url +" 没有对应的权限名称");
    }

}
