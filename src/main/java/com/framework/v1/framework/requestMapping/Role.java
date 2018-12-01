package com.framework.v1.framework.requestMapping;


import java.util.ArrayList;
import java.util.List;


public class Role {


    private String id ;
    private String name ;

    private String sign ;

    private Boolean checked = false;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    Role(){}

    public Role(String id, String name , String sign) {
        this.id = id ;
        this.name = name;
        this.sign = sign;
    }

    public String getId() {
        return id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public static List<Role> loadAndCheck(List<Role> roles, List<Role> allRoles) {
        List<Role> plist = new ArrayList<Role>();
        plist.addAll(allRoles);
        if(plist == null ||plist.isEmpty())
            return plist;
        for(Role role :plist){
            role.setChecked(false);
            if(role.isInRole(roles)){
                role.setChecked(true);
            }
        }
        return plist;
    }

    private boolean isInRole(List<Role> roles) {
        if(roles == null || roles.isEmpty())
            return false;
        for(Role rp : roles){
            if(this.id.equals(rp.getId()))
                return  true;
        }
        return false;
    }
}
