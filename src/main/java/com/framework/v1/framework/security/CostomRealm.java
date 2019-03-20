package com.framework.v1.framework.security;


import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysUsers.vo.UserVO;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

public class CostomRealm extends AuthorizingRealm {



    @Resource
    private PermsUserService permsUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }




    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        try {
            UserVO user = permsUserService.queryUserByUsername(name);
            String password =new String( (char[])authenticationToken.getCredentials());

            //password = GenerateUtil.toMd5(password);
            if (user == null) {
                //这里返回后会报出对应异常
                return null;
            } else {
                //这里验证authenticationToken和simpleAuthenticationInfo的信息
                SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getSysUserModel().getPassword().toString(), getName());
                return simpleAuthenticationInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
