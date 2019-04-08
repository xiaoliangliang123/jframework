package com.framework.v1.business.sysSetting.sysUsers.service.impl;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseServiceAdapter;
import com.framework.v1.business.sysSetting.sysUsers.dao.PermsGroupDao;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_Group_ViewModel;
import com.framework.v1.business.sysSetting.sysUsers.service.PermsGroupViewService;
import com.framework.v1.framework.database.base.QueryParams;
import com.framework.v1.framework.util.GenerateUtil;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermsGroupViewServiceImpl  extends BaseServiceAdapter implements PermsGroupViewService {


    @Override
    public QueryParams baseQuery() {
        return new QueryParams(" select sys_perms_group_view.*,sys_perms_group.name gname from sys_perms_group_view , sys_perms_group where sys_perms_group_view.groupId = sys_perms_group.uid "," order by seq asc");
    }

    @Override
    public JsonResult addOrEditPermsGroupView(Sys_Perms_Group_ViewModel sysPermsGroupViewModel) throws Exception {


        if(StringUtil.isEmpty(sysPermsGroupViewModel.getId())){
            sysPermsGroupViewModel.setId(GenerateUtil.uuid());
            getjBaseDao().insertModel(sysPermsGroupViewModel);
        }else {
            getjBaseDao().updateModel(sysPermsGroupViewModel);

        }
        return new JsonResult("保存成功");
    }
}
