package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.common.dao.UserDao;
import com.framework.v1.business.common.model.UserModel;
import com.framework.v1.business.sysUsers.service.UserService;
import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.util.GenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public JsonResult addUser(String username, String password) throws Exception {

        //DatasourceContextHolder.setCurrentDbWrite();
        if(userDao.checkUsernameIsExsit(username)){
            JsonResult jsonResult = new JsonResult(false, "用户名已存在");
            return jsonResult;
        }
        UserModel userModel = new UserModel();
        userModel.setId(GenerateUtil.uuid());
        userModel.setUsername(username);
        userModel.setPassword(password);
        getjBaseDao().insertModel(userModel);
        JsonResult jsonResult = new JsonResult(true, "添加成功");
        return jsonResult;


    }
}
