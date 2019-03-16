package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dao.UserDao;
import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class PermsUserServiceImpl extends BaseServiceAdapter implements PermsUserService {


    @Autowired
    private UserDao userDao;

    @Override
    public JsonResult addOrEditUser(String userid, String username, String password) throws Exception {

        if(StringUtil.isEmpty(userid)){
            if(userDao.checkUsernameIsExsit(username)){
                JsonResult jsonResult = new JsonResult(false, "用户名已存在");
                return jsonResult;
            }
            Sys_UserModel userModel = new Sys_UserModel();
            userModel.setId(GenerateUtil.uuid());
            userModel.setUsername(username);
            userModel.setPassword(password);
            userModel.setDate(GenerateUtil.currentTime());
            getjBaseDao().insertModel(userModel);
            JsonResult jsonResult = new JsonResult(true, "添加成功");
            return jsonResult;

        }else {
            Sys_UserModel userModel = new Sys_UserModel();
            userModel.setId(userid);
            userModel.setUsername(username);
            userModel.setPassword(password);
            userModel.setDate(GenerateUtil.currentTime());
            getjBaseDao().updateModel(userModel);
            JsonResult jsonResult = new JsonResult(true, "编辑成功");
            return jsonResult;
        }



    }

    @Override
    public JsonResult removeUser(String userId) throws Exception {
        Sys_UserModel userModel = new Sys_UserModel();
        userModel.setId(userId);
        getjBaseDao().deleteModel(userModel);

        return  new JsonResult(true, "删除成功") ;
    }

    @Override
    public JsonResult getUserinfo(String userId) throws Exception {

        Sys_UserModel userModel = new Sys_UserModel();
        userModel.setId(userId);
        userModel = (Sys_UserModel) getjBaseDao().selectModel(userModel);
        return   new JsonResult(true, "获取用户信息成功",userModel) ;
    }


    @Override
    public String baseQuery() {


        return "select * from sys_user ";
    }
}
