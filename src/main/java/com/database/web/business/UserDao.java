package com.database.web.business;

import com.database.web.framework.database.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends BaseDao{



    public List<Map<String,Object>> getAllUsers(){
        String sql= "select * from user";
        return  getjBaseDao().queryForList(sql);
    }

    public void updateAllUsers(){
        String sql= "select * from user";
        getjBaseDao().update("");
    }


    public void addUsers(){
        String sql = "";

    }

}
