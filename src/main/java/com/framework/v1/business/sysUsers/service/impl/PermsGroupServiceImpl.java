package com.framework.v1.business.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysUsers.dao.PermsGroupDao;
import com.framework.v1.business.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysUsers.service.PermsGroupService;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermsGroupServiceImpl  extends BaseServiceAdapter implements PermsGroupService {

    @Autowired
    private PermsGroupDao permsGroupDao;

    @Override
    public QueryParams baseQuery() {
        return new QueryParams("select * from sys_perms_group","");
    }

    @Override
    public JsonResult addOrEditPermsGroup(String uid, String permsGroupId, String permsGroupName) throws Exception {


        if(StringUtil.isEmpty(uid)){
            if(permsGroupDao.checkPermGroupIdIsExsit(permsGroupId)){
                JsonResult jsonResult = new JsonResult(false, "权限集id已经存在");
                return jsonResult;
            }
            Sys_Perms_GroupModel permsGroupModel = new Sys_Perms_GroupModel();
            permsGroupModel.setUid(GenerateUtil.uuid());
            permsGroupModel.setName(permsGroupName);
            permsGroupModel.setId(permsGroupId);
            getjBaseDao().insertModel(permsGroupModel);

            JsonResult jsonResult = new JsonResult(true, "添加成功");
            return jsonResult;

        }else {
            Sys_Perms_GroupModel permsGroupModel = new Sys_Perms_GroupModel();
            permsGroupModel.setUid(uid);
            permsGroupModel.setName(permsGroupName);
            permsGroupModel.setId(permsGroupId);
            getjBaseDao().updateModel(permsGroupModel);
            JsonResult jsonResult = new JsonResult(true, "编辑成功");
            return jsonResult;
        }

    }

    @Override
    public JsonResult removePermsGroup(String uid) throws Exception {
        Sys_Perms_GroupModel sys_perms_groupModel = new Sys_Perms_GroupModel();
        sys_perms_groupModel.setUid(uid);
        getjBaseDao().deleteModel(sys_perms_groupModel);

        return  new JsonResult(true, "删除成功") ;
    }

    @Override
    public JsonResult getPermsGroupInfo(String uid) throws Exception {
        Sys_Perms_GroupModel sys_perms_groupModel = new Sys_Perms_GroupModel();
        sys_perms_groupModel.setUid(uid);
        sys_perms_groupModel = (Sys_Perms_GroupModel)getjBaseDao().selectModel(sys_perms_groupModel);
        return   new JsonResult(true,"获取权限集成功", sys_perms_groupModel) ;

    }

    @Override
    public Sys_Perms_GroupModel getSysPermsModel(String uid) throws Exception {
        Sys_Perms_GroupModel sys_perms_groupModel = new Sys_Perms_GroupModel();
        sys_perms_groupModel.setUid(uid);
        sys_perms_groupModel = (Sys_Perms_GroupModel)getjBaseDao().selectModel(sys_perms_groupModel);
        return sys_perms_groupModel;
    }
}
