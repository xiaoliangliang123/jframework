package com.framework.v1.business.common.dao;

import com.framework.v1.framework.database.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends BaseDao{



    public List<Map<String,Object>> getAllUsers(){
        String sql= "select * from user where id = ?  order by id asc";
        return  getjBaseDao().queryForList(sql,new Object[]{"1"});
    }

    public void updateAllUsers(){
        String sql= "select * from user";
        getjBaseDao().update("");
    }



    public boolean checkUsernameIsExsit(String username) {


       Map map = getjBaseDao().getJdbcTemplate().queryForMap("select * from user where username = ?",new String[]{username});
       return map!=null;
    }
}
