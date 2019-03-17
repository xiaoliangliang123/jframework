package com.framework.v1.business.common.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.common.service.CommonService;
import com.framework.v1.business.sysUsers.dao.UserDao;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysUsers.vo.SysPermsGroupUrlVO;
import com.framework.v1.business.sysUsers.vo.UserVO;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.Role;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import com.framework.v1.framework.util.WebPropertyUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

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
    public String baseQuery() {
        return null;
    }
}
