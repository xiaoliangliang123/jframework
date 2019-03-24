package com.framework.v1.framework.security;

import com.framework.v1.business.sysSetting.sysUsers.vo.UserVO;
import com.framework.v1.framework.error.NoLoginException;
import com.framework.v1.framework.requestMapping.Role;
import com.framework.v1.framework.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomRolesAuthorizationFilter extends AuthorizationFilter {



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {



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
