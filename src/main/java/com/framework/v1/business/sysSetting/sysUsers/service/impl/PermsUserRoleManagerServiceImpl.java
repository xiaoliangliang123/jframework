package com.framework.v1.business.sysSetting.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysSetting.sysUsers.dto.PermissionUserRolesManagerDTO;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_UserModel;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsUserRoleManagerService;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PermsUserRoleManagerServiceImpl  extends BaseServiceAdapter implements PermsUserRoleManagerService {




    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult savePermsUserRoles(String permsUserId, String[] permsRoleIds) {

        List<String> idsList = new ArrayList<String>(Arrays.asList(permsRoleIds));
        String sql = "delete from sys_perms_user_role where user_id = ?";
        getjBaseDao().update(sql,new String[]{permsUserId});
        sql = "insert into sys_perms_user_role(id,user_id,role_id) values(?,?,?)";
        getjBaseDao().batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return idsList.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {
                ps.setString(1, GenerateUtil.uuid());
                ps.setString(2, permsUserId);
                ps.setString(3, idsList.get(i));
            }
        });

        return new JsonResult("保存成功");
    }

    @Override
    public JsonResult queryRolesForUserId(String permsUserId) throws Exception {

        String sql = "select * from sys_perms_role ";
        List<Map> rolesMapList =  getjBaseDao().queryForList(sql);
        List<Sys_Perms_RoleModel> sysPermsUserRoleModels = DataUtil.copyListMap2ListBean(rolesMapList,Sys_Perms_RoleModel.class);

        sql = "select sys_perms_role.id from sys_perms_role , sys_perms_user_role where sys_perms_role.id = sys_perms_user_role.role_id and sys_perms_user_role.user_id ='"+permsUserId+"'";
        rolesMapList =  getjBaseDao().queryForList(sql);
        List<String>  userRolesIds= DataUtil.getStringListForKey("id", rolesMapList);

        Sys_UserModel sysUserModel = new Sys_UserModel();
        sysUserModel.setId(permsUserId);
        sysUserModel = (Sys_UserModel)getjBaseDao().selectModel(sysUserModel);

        PermissionUserRolesManagerDTO permissionUserRolesManagerDTO = new PermissionUserRolesManagerDTO(sysUserModel,userRolesIds,sysPermsUserRoleModels);
        return new JsonResult(permissionUserRolesManagerDTO);
    }
}
