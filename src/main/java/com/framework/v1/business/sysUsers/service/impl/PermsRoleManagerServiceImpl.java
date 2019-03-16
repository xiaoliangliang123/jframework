package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dto.PermissionRoleManagerDTO;
import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysUsers.service.PermsRoleManagerService;
import com.framework.v1.business.sysUsers.vo.SysPermsGroupUrlVO;
import com.framework.v1.framework.requestMapping.Permission;
import com.framework.v1.framework.requestMapping.RequestMappingUtil;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PermsRoleManagerServiceImpl   extends BaseServiceAdapter implements PermsRoleManagerService {

    @Resource
    private RequestMappingUtil requestMappingUtil;

    @Override
    public JsonResult queryModulesForRoleId(String permsRoleId) throws Exception {

        String sql = "select  url from sys_perms_role_urls   where  role_id  =   '"+permsRoleId+"'";
        List<Map> pgrMapList =  getjBaseDao().queryForList(sql);

        List<String> rolePermsUrls = DataUtil.getStringListForKey("url", pgrMapList);
        sql = "select  spg.uid as id, spg.name as name,spgus.perms_group_url as url from   sys_perms_group  spg , sys_perms_group_urls spgus  where  spgus.perms_group_id = spg.uid group by  spg.uid , spg.name ,spgus.perms_group_url ";
        List<Map> allPermsGroupModels =  getjBaseDao().queryForList(sql);
        allPermsGroupModels = putInPermName(allPermsGroupModels);

        List<SysPermsGroupUrlVO> sysPermsGroupUrlVOS = DataUtil.copyListMap2ListBean(allPermsGroupModels,SysPermsGroupUrlVO.class);
        Map<String, List<SysPermsGroupUrlVO>> sysPermsGroupUrlsMap = sysPermsGroupUrlVOS.stream().collect(Collectors.groupingBy(SysPermsGroupUrlVO::getName));
                //DataUtil.groupBy(sysPermsGroupUrlVOS,SysPermsGroupUrlVO::getName);
        System.out.println(sysPermsGroupUrlsMap.toString());
        Sys_Perms_RoleModel sys_perms_roleModel = new Sys_Perms_RoleModel();
        sys_perms_roleModel.setId(permsRoleId);
        sys_perms_roleModel =  (Sys_Perms_RoleModel) getjBaseDao().selectModel(sys_perms_roleModel);

        PermissionRoleManagerDTO permissionRoleManagerDTO = new PermissionRoleManagerDTO(sys_perms_roleModel,rolePermsUrls,sysPermsGroupUrlsMap);
        return new JsonResult(permissionRoleManagerDTO);
    }

    private List<Map> putInPermName(List<Map> allPermsGroupModels) throws NoSuchFieldException {
        for(Map map:allPermsGroupModels){
            Permission permission =  requestMappingUtil.getPermissionForUrl((String) map.get("url"));
            map.put("uname",permission.getCommont());
        }
        return allPermsGroupModels;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult savePermsRoleUrls(String permsRoleId, String[] permsRoleUrls) {

        //String[] idsArray = permsRoleUrls.split(",");
        List<String> idsList = new ArrayList<String>(Arrays.asList(permsRoleUrls));
        String sql = "delete from sys_perms_role_urls where role_id = ?";
        getjBaseDao().update(sql,new String[]{permsRoleId});
        sql = "insert into sys_perms_role_urls(id,role_id,url) values(?,?,?)";
        getjBaseDao().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return idsList.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {
                ps.setString(1, GenerateUtil.uuid());
                ps.setString(2, permsRoleId);
                ps.setString(3, idsList.get(i));
            }
        });

        return new JsonResult("保存成功");
    }
}
