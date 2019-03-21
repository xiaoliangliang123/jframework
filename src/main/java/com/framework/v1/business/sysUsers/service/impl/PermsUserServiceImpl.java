package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dao.UserDao;
import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import com.framework.v1.business.sysUsers.vo.UserVO;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.Role;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class PermsUserServiceImpl extends BaseServiceAdapter implements PermsUserService {


    @Autowired
    private UserDao userDao;

    @Override
    public JsonResult addOrEditUser(String userid, String username,String nickname) throws Exception {


        if(StringUtil.isEmpty(userid)){
            if(userDao.checkUsernameIsExsit(username)){
                JsonResult jsonResult = new JsonResult(false, "用户名已存在");
                return jsonResult;
            }
            Sys_UserModel userModel = new Sys_UserModel();
            userModel.setId(GenerateUtil.uuid());
            userModel.setUsername(username);
            String password = GenerateUtil.toMd5(GenerateUtil.INIT_PASSWORD);
            userModel.setPassword(password);
            userModel.setNickname(nickname);
            userModel.setDate(GenerateUtil.currentTime());
            getjBaseDao().insertModel(userModel);
            JsonResult jsonResult = new JsonResult(true, "添加成功");
            return jsonResult;

        }else {
            Sys_UserModel userModel = new Sys_UserModel();
            userModel.setId(userid);
            userModel.setUsername(username);
            userModel.setNickname(nickname);
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

    public Sys_UserModel getUserModelByUsername(String username) throws Exception {

        String sql = "select * from sys_user where username = ?";
        Map umap = getjBaseDao().queryForMap(sql,new Object[]{username});
        Sys_UserModel sysUserModel = DataUtil.copyMap2Bean(umap,Sys_UserModel.class);
        return sysUserModel;
    }

    @Override
    public UserVO queryUserByUsername(String username) throws Exception {

        String userId = userDao.queryUserIdByUsername(username);
        Sys_UserModel sysUserModel = userDao.queryUserById(userId);
        List<Permission> permissions = queryUserPermissionByUserId(userId);
        List<Role> roles =  queryUserRolesByUserId(userId);
        UserVO userVO = new UserVO(sysUserModel,permissions,roles);
        return userVO;
    }

    public List<Role> queryUserRolesByUserId(String userId) throws Exception {
        String sql = "select sys_perms_role.* from sys_perms_role , sys_perms_user_role where sys_perms_role.id = sys_perms_user_role.role_id and sys_perms_user_role.user_id ='"+userId+"'";
        List<Map> rolesMapList =  getjBaseDao().queryForList(sql);
        List<Role> roles = DataUtil.copyListMap2ListBean(rolesMapList,Role.class);
        return roles;
    }


    public List<Permission> queryUserPermissionByUserId(String userId) throws Exception {

        String sql = "select sys_perms_role_urls.url from sys_perms_user_role,sys_perms_role , sys_perms_role_urls where sys_perms_role.id = sys_perms_role_urls.role_id and sys_perms_user_role.role_id = sys_perms_role.id and sys_perms_user_role.user_id ='"+userId+"'";
        List<Map> rolesMapList =  getjBaseDao().queryForList(sql);
        List<Permission> permissions = DataUtil.copyListMap2ListBean(rolesMapList,Permission.class);

        return permissions;
    }

    @Override
    public QueryParams baseQuery() {


        return new QueryParams("select * from sys_user ","");
    }
}
