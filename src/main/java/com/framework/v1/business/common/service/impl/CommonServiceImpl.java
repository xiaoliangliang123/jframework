package com.framework.v1.business.common.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.common.service.CommonService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("commonService")
public class CommonServiceImpl extends BaseService implements CommonService{


    @Override
    public JsonResult login(String username, String password) {



        return new JsonResult(true,"登陆成功");
    }


    @Override
    public String baseQuery() {
        return null;
    }
}
