package com.framework.v1.framework.security;

import com.framework.v1.framework.util.GenerateUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        try{
            UsernamePasswordToken utoken=(UsernamePasswordToken) token;
            String inPassword = new String(utoken.getPassword());
            //获得数据库中的密码
            String dbPassword = (String) info.getCredentials();

            inPassword = GenerateUtil.toMd5(inPassword);
            if(dbPassword.equals(inPassword)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return  false;
        }

    }
}
