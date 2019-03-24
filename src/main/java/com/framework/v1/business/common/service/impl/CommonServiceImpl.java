package com.framework.v1.business.common.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.common.service.CommonService;
import com.framework.v1.business.sysSetting.sysUsers.dao.UserDao;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysSetting.sysUsers.vo.UserVO;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commonService")
public class CommonServiceImpl extends BaseService implements CommonService{

    @Resource
    private UserDao userDao;
    @Resource
    private PermsUserService permsUserService;

    @Override
    public JsonResult login(String username, String password) throws Exception {


        password = GenerateUtil.toMd5(password);
        UserVO userVO = permsUserService.queryUserByUsername(username);
        if(!StringUtil.isEmpty(userVO)){

            return new JsonResult(true,"登陆成功");
        }
        return new JsonResult(false,"用户名或密码错误");
    }




    @Override
    public QueryParams baseQuery() {
        return null;
    }
}
