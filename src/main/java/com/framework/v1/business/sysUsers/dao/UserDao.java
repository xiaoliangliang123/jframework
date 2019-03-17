package com.framework.v1.business.sysUsers.dao;

import com.framework.v1.business.sysUsers.model.Sys_UserModel;
import com.framework.v1.framework.database.base.BaseDao;
import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends BaseDao {


    public List<Map<String, Object>> getAllUsers() {
        String sql = "select * from sys_user where id = ?  order by id asc";
        return getjBaseDao().queryForList(sql, new Object[]{"1"});
    }

    public void updateAllUsers() {
        String sql = "select * from sys_user";
        getjBaseDao().update("");
    }


    public boolean checkUsernameIsExsit(String username) {

        List<Map<String, Object>> results = getjBaseDao().queryForList("select * from sys_user where username = ?", new String[]{username});
        return results != null && !results.isEmpty();
    }

    public List<Map<String, Object>> queryUsers(String username) {


        StringBuffer sql = new StringBuffer("select * from sys_user ");
        if(!StringUtil.isEmpty(username)){
            sql.append(" where username like'%"+username+"%'");
            return getjBaseDao().queryForList(sql.toString());
        }
        return getjBaseDao().queryForList(sql.toString());

    }

    public boolean checkUseIsExsit(String username, String password) {
        String sql = "select * from  sys_user where username = ? and password = ?";
        Integer  count = getjBaseDao().queryForInt(sql,new Object[]{username,password});
        return count!=0;
    }

    public String queryIdByUsernameAndPassowrd(String username, String password) {
        String sql = "select id from  sys_user where username = ? and password = ?";
        String userId = getjBaseDao().queryForString(sql,new Object[]{username,password});
        return userId;
    }

    public Sys_UserModel queryUserById(String userId) throws Exception {
        Sys_UserModel sysUserModel = new Sys_UserModel();
        sysUserModel.setId(userId);
        return (Sys_UserModel)getjBaseDao().selectModel(sysUserModel);
    }

    public String queryUserIdByUsername(String username) {
        String sql = "select id from  sys_user where username = ? ";
        String userId = getjBaseDao().queryForString(sql,new Object[]{username});
        return userId;
    }
}
