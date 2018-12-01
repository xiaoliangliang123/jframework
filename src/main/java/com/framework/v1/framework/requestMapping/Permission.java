package com.framework.v1.framework.requestMapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Permission {

    private String url ;

    private String method ;

    private String commont ;

    private boolean checked = false;

    public Permission(){}

    public Permission(String url, String method, String commont) {
        this.url = url;
        this.method = method;
        this.commont = commont;
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

    public static List<Permission> loadAndChecked(List<Permission> permissions, List<RolePerms> rplsit) {

        List<Permission> plist = new ArrayList<Permission>();
        plist.addAll(permissions);
        if(permissions == null ||permissions.isEmpty())
            return plist;
        for(Permission permission :plist){
            permission.setChecked(false);
            if(permission.isInRolePerms(rplsit)){
                permission.setChecked(true);
            }
         }
        return plist;
    }

    public  boolean isInRolePerms(List<RolePerms> rplsit) {
       if(rplsit == null || rplsit.isEmpty())
           return false;
       for(RolePerms rp : rplsit){
          if(this.isEq(rp))
              return  true;
       }
       return false;
    }

    private boolean isEq(RolePerms rp) {
        if(this.method != null ) {
            return this.url.equals(rp.getUrl()) && this.method.equals(rp.getMethod());
        }
        else{
            return this.url.equals(rp.getUrl()) ;
        }

    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
