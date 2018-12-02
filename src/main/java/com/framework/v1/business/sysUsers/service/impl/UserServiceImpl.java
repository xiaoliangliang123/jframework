package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.common.dao.UserDao;
import com.framework.v1.business.common.model.UserModel;
import com.framework.v1.business.sysUsers.service.UserService;
import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.util.GenerateUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public JsonResult addUser(String username, String password) throws Exception {

        if(userDao.checkUsernameIsExsit(username)){
            JsonResult jsonResult = new JsonResult(false, "用户名已存在");
            return jsonResult;
        }
        UserModel userModel = new UserModel();
        userModel.setId(GenerateUtil.uuid());
        userModel.setUsername(username);
        userModel.setPassword(password);
        userModel.setDate(GenerateUtil.currentTime());
        getjBaseDao().insertModel(userModel);
        JsonResult jsonResult = new JsonResult(true, "添加成功");
        return jsonResult;


    }

    @Override
    public JsonResult listUser(String username) {

        DatasourceContextHolder.setCurrentDbWrite();
        List<Map<String, Object>> mapList = userDao.queryUsers(username);
        //String jsonStr = JSONArray.fromObject(mapList).toString();

        return new JsonResult(true,"加载列表成功",mapList);
    }


    @Override
    public String baseQuery() {


        return null;
    }
}
