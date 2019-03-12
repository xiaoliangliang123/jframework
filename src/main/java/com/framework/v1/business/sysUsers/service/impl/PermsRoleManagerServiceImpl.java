package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dto.PermissionRoleManagerDTO;
import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysUsers.service.PermsRoleManagerService;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class PermsRoleManagerServiceImpl   extends BaseServiceAdapter implements PermsRoleManagerService {

    @Override
    public JsonResult queryModulesForRoleId(String permsRoleId) throws Exception {

        String sql = "select spg.uid , spg.name , spg.id from sys_perms_role_modules sprm , sys_perms_group  spg where  sprm.group_id = spg.uid and sprm.role_id =   '"+permsRoleId+"'";
        List<Map> pgrMapList =  getjBaseDao().queryForList(sql);

        List<String> rolePermsGroupModels = DataUtil.getStringListForKey("uid", pgrMapList);
        sql = "select * from sys_perms_group";
        List<Map> allPermsGroupModels =  getjBaseDao().queryForList(sql);

        Sys_Perms_RoleModel sys_perms_roleModel = new Sys_Perms_RoleModel();
        sys_perms_roleModel.setId(permsRoleId);
        sys_perms_roleModel =  (Sys_Perms_RoleModel) getjBaseDao().selectModel(sys_perms_roleModel);

        PermissionRoleManagerDTO permissionRoleManagerDTO = new PermissionRoleManagerDTO(sys_perms_roleModel,rolePermsGroupModels,allPermsGroupModels);
        return new JsonResult(permissionRoleManagerDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult savePermsModules(String permsRoleId, String permsModulesIds) {

        String[] idsArray = permsModulesIds.split(",");
        List<String> idsList = new ArrayList<String>(Arrays.asList(idsArray));
        String sql = "delete from sys_perms_role_modules where role_id = ?";
        getjBaseDao().update(sql,new String[]{permsRoleId});
        sql = "insert into sys_perms_role_modules(id,role_id,group_id) values(?,?,?)";
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
