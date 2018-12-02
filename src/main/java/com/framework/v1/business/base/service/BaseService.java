package com.framework.v1.business.base.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.framework.database.base.BaseDao;

import java.util.List;
import java.util.Map;

public abstract class BaseService extends BaseDao {


    public JsonResult baseList() {


        String sql =  baseQuery();
        List<Map<String,Object>> mapList = getjBaseDao().queryForList(sql);
        return new JsonResult(true,"",mapList);
    }

    public abstract String baseQuery() ;


}
