package com.framework.v1.framework.security;

import com.framework.v1.business.sysUsers.vo.UserVO;
import com.framework.v1.framework.error.NoLoginException;
import com.framework.v1.framework.util.StringUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomRolesAuthorizationFilter extends AuthorizationFilter {



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {



        UserVO userVO = (UserVO)SecurityUtils.getSubject().getPrincipal();
        String requestPath = getRequestPath(request);
        if(StringUtil.isEmpty(userVO)){
            throw new NoLoginException();
        }
        Boolean hasPerm =  userVO.hasPermissionForParh(requestPath);
        return hasPerm;


    }

    protected String getRequestPath(ServletRequest request) {
        String[] perms = new String[1];
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();

        return path;
    }
}
