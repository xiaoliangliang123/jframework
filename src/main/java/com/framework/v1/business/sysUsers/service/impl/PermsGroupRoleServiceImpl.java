package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dao.PermsRoleDao;
import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.model.Sys_Perms_RoleModel;
import com.framework.v1.business.sysUsers.service.PermsGroupRoleService;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermsGroupRoleServiceImpl  extends BaseServiceAdapter implements PermsGroupRoleService {



    @Autowired
    private PermsRoleDao permsRoleDao;


    @Override
    public String baseQuery() {


        return "select * from sys_perms_role ";
    }

    @Override
    public JsonResult addOrEditPermsRole(String id, String roleId, String roleName) throws Exception {


        if(StringUtil.isEmpty(id)){
            if(permsRoleDao.checkRoleIdIsExsit(roleId)){
                JsonResult jsonResult = new JsonResult(false, "角色Id已经存在");
                return jsonResult;
            }
            Sys_Perms_RoleModel permsRoleModel = new Sys_Perms_RoleModel();
            permsRoleModel.setId(GenerateUtil.uuid());
            permsRoleModel.setRole_id(roleId);
            permsRoleModel.setRole_name(roleName);
            getjBaseDao().insertModel(permsRoleModel);

            JsonResult jsonResult = new JsonResult(true, "添加成功");
            return jsonResult;

        }else {
            Sys_Perms_RoleModel permsRoleModel = new Sys_Perms_RoleModel();
            permsRoleModel.setId(id);
            permsRoleModel.setRole_id(roleId);
            permsRoleModel.setRole_name(roleName);
            getjBaseDao().insertModel(permsRoleModel);
            JsonResult jsonResult = new JsonResult(true, "编辑成功");
            return jsonResult;
        }
    }
}
