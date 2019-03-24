package com.framework.v1.framework.requestMapping;


import com.framework.v1.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.List;


public class Role {


    public static String SUPER_ADMIN = "SUPER_ADMIN";


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

    public String getRoleId(){
        return role_id;
    }

    public String getRoleName(){
        return role_name;
    }


    public Role(){}



    private boolean isInRole(List<Role> roles) {
        if(roles == null || roles.isEmpty())
            return false;
        for(Role rp : roles){
            if(this.role_id.equals(rp.getRole_id()))
                return  true;
        }
        return false;
    }

    public static boolean hasRoleIdOf(String roleId, List<Role> roles) {
        if(StringUtil.isEmpty(roles)){
            return false;
        }
        for(Role role:roles){
            if(role.isIdOf(roleId)){
                return true;
            }
        }
        return false;
    }

    public boolean isIdOf(String roleId) {
        return roleId.equals(getRole_id());
    }
}
