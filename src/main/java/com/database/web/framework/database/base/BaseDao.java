package com.database.web.framework.database.base;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {


    @Autowired
    private JBaseDao jBaseDao;

    public JBaseDao getjBaseDao() {
        return jBaseDao;
    }

}
