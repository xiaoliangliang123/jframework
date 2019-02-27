package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.base.service.PageInfo;
import com.framework.v1.business.sysUsers.service.PermsGroupManagerService;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
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
public class PermsGroupManagerServiceImpl  extends BaseService implements PermsGroupManagerService {

    @Resource
    private RequestMappingUtil requestMappingUtil;

    @Resource
    private PermsGroupService permsGroupService;


    @Override
    public JsonResult baseList() throws Exception {

        return permsGroupService.baseList();
    }




    @Override
    public String baseQuery() {
        return null;
    }
}
