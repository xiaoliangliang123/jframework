package com.framework.v1.business.sysUsers.dao;

import com.framework.v1.framework.database.base.BaseDao;
import com.framework.v1.framework.database.config.DatasourceContextHolder;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends BaseDao {


    public List<Map<String, Object>> getAllUsers() {
        String sql = "select * from user where id = ?  order by id asc";
        return getjBaseDao().queryForList(sql, new Object[]{"1"});
    }

    public void updateAllUsers() {
        String sql = "select * from user";
        getjBaseDao().update("");
    }


    public boolean checkUsernameIsExsit(String username) {

        List<Map<String, Object>> results = getjBaseDao().queryForList("select * from user where username = ?", new String[]{username});
        return results != null && !results.isEmpty();
    }

    public List<Map<String, Object>> queryUsers(String username) {


        StringBuffer sql = new StringBuffer("select * from user ");
        if(!StringUtil.isEmpty(username)){
            sql.append(" where username like'%"+username+"%'");
            return getjBaseDao().queryForList(sql.toString());
        }
        return getjBaseDao().queryForList(sql.toString());

    }
}
