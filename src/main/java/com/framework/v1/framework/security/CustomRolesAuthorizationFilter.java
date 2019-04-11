package com.framework.v1.framework.security;

import com.framework.v1.business.sysSetting.sysUsers.vo.UserVO;
import com.framework.v1.framework.database.config.SpringUtil;
import com.framework.v1.framework.database.config.SysConfigBean;
import com.framework.v1.framework.error.NoLoginException;
import com.framework.v1.framework.requestMapping.Role;
import com.framework.v1.framework.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

public class CustomRolesAuthorizationFilter extends AuthorizationFilter {


    //@Resource
    //private SysConfigBean sysConfigBean;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {



        /*
        if(!sysConfigBean.isAuth()){
            return true;
        }
        */


        SysConfigBean sysConfigBean =  (SysConfigBean)SpringUtil.getBean("sysConfigBean");
        UserVO userVO = (UserVO)SecurityUtils.getSubject().getPrincipal();
        if(StringUtil.isEmpty(userVO)||!userVO.hasRoleOf(Role.SUPER_ADMIN)){
            String requestPath = getRequestPath(request);
            if(StringUtil.isEmpty(userVO)){
                throw new NoLoginException();
            }
            Boolean hasPerm =  userVO.hasPermissionForParh(requestPath);
            return hasPerm;
        }
        return true;

    }

    protected String getRequestPath(ServletRequest request) {
        String[] perms = new String[1];
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();

        return path;
    }
}
