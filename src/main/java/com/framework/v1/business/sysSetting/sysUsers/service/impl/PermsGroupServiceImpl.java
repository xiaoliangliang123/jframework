package com.framework.v1.business.sysSetting.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysSetting.sysUsers.dao.PermsGroupDao;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_GroupModel;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsGroupService;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.util.DataUtil;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PermsGroupServiceImpl  extends BaseServiceAdapter implements PermsGroupService {

    @Autowired
    private PermsGroupDao permsGroupDao;

    @Override
    public QueryParams baseQuery() {
        return new QueryParams("select * from sys_perms_group where isTop = 0","");
    }

    @Override
    public JsonResult addOrEditPermsGroup(Sys_Perms_GroupModel sysPermsGroupModel) throws Exception {


        if(StringUtil.isEmpty(sysPermsGroupModel.getUid())){
            if(permsGroupDao.checkPermGroupIdIsExsit(sysPermsGroupModel.getId())){
                JsonResult jsonResult = new JsonResult(false, "权限集id已经存在");
                return jsonResult;
            }
            sysPermsGroupModel.setUid(GenerateUtil.uuid());
            getjBaseDao().insertModel(sysPermsGroupModel);

            JsonResult jsonResult = new JsonResult(true, "添加成功");
            return jsonResult;

        }else {
            getjBaseDao().updateModel(sysPermsGroupModel);
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

    @Override
    public JsonResult queryTopModuleList() throws Exception {

        String sql = "select * from sys_perms_group where isTop = 1 ";
        List<Map> mapList =  getjBaseDao().queryForList(sql);
        List<Sys_Perms_GroupModel> allTopModels =DataUtil.copyListMap2ListBean(mapList,Sys_Perms_GroupModel.class);
        return new JsonResult(allTopModels);
    }
}
