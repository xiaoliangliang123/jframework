package com.framework.v1.business.sysUsers.dao;

import com.framework.v1.framework.database.base.BaseDao;
import com.framework.v1.framework.database.config.DatasourceContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PermsGroupDao extends BaseDao {

    public boolean checkPermGroupIdIsExsit(String permsGroupId) {
        List<Map<String, Object>> results = getjBaseDao().queryForList("select * from sys_perms_group where id = ?", new String[]{permsGroupId});
        return results != null && !results.isEmpty();
    }
}
