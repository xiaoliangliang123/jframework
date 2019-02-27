package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.base.service.PageInfo;
import com.framework.v1.business.sysUsers.service.PermsService;
import com.framework.v1.business.sysUsers.service.UserService;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.RequestMappingUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Component
public class PermsServiceImpl  extends BaseService implements PermsService {

    @Resource
    private RequestMappingUtil requestMappingUtil;




    @Override
    public JsonResult baseList() throws Exception {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map map = request.getParameterMap();

        PageInfo pageInfo = PageInfo.init(map);
        List<Permission> permissions = requestMappingUtil.getPermissions();
        List<Permission> perms = permissions.subList(pageInfo.getNoSqlStart(),pageInfo.getNoSqlEnd(permissions.size()));
        //List<Permission> perms = permissions.subList(5,1);
        return new JsonResult(perms,permissions.size(),1,0);
    }

    @Override
    public String baseQuery() {
        return null;
    }
}
