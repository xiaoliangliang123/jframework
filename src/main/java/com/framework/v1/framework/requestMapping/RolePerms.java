package com.framework.v1.framework.requestMapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RolePerms implements Serializable {

    private int id;

    private String roleId;

    private String url;

    private String method;

    private String commont;

    public RolePerms(){}

    public RolePerms(String roleId, String url, String method, String commont) {
        this.roleId = roleId;
        this.url = url;
        this.method = method;
        this.commont = commont;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCommont() {
        return commont;
    }

    public void setCommont(String commont) {
        this.commont = commont;
    }

    public static List<RolePerms> loadRolePerms(String roleId, String[] permId) {

        List<RolePerms> rplist = new ArrayList<RolePerms>();
        String method = "";
        String commont = "";
        for(String perm:permId){
            String[] os = perm.split("\\|");

            String url = os[0];
            if(os.length ==3) {
                method = os[1];
                commont = os[2];
            }
            else  if(os.length ==2) {
                method = os[1];
            }
            rplist.add(new RolePerms(roleId, url,method,commont));
        }
        return rplist;
    }
}
