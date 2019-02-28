package com.framework.v1.business.sysUsers.dao;

import com.framework.v1.framework.database.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PermsRoleDao  extends BaseDao {


    public boolean checkRoleIdIsExsit(String roleId) {

        List<Map<String, Object>> results = getjBaseDao().queryForList("select * from sys_perms_role where role_id = ?", new String[]{roleId});
        return results != null && !results.isEmpty();
    }

}
