package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.base.service.PageInfo;
import com.framework.v1.business.sysUsers.service.PermsGroupManagerService;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.RequestMappingUtil;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Component
public class PermsGroupManagerServiceImpl extends BaseServiceAdapter implements PermsGroupManagerService {

    @Resource
    private RequestMappingUtil requestMappingUtil;

    @Resource
    private PermsGroupService permsGroupService;


    @Override
    public JsonResult baseList() throws Exception {

        return permsGroupService.baseList();
    }


    @Override
    public List<String> queryPermsModuleUrlsWith(String permsGroupId) {

        String sql = "select perms_group_url from  sys_perms_group_urls where perms_group_id = '" + permsGroupId + "'";
        List<Map> urlsMapList = getjBaseDao().queryForList(sql);
        List<String> urls = DataUtil.getStringListForKey("perms_group_url", urlsMapList);
        return urls;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult savePermsGroupUrls(String permsGroupId, String permsUrlValues) {


        String[] urlArray = permsUrlValues.split(",");
        List<String> urlsList = new ArrayList<String>(Arrays.asList(urlArray));
        String sql = "delete from sys_perms_group_urls where perms_group_id = ?";
        getjBaseDao().update(sql,new String[]{permsGroupId});
        sql = "insert into sys_perms_group_urls(id,perms_group_id,perms_group_url) values(?,?,?)";
        getjBaseDao().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return urlsList.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {
                ps.setString(1, GenerateUtil.uuid());
                ps.setString(2, permsGroupId);
                ps.setString(3, urlsList.get(i));
            }
        });

        return new JsonResult("保存成功");
    }
}
