package com.framework.v1.business.sysSetting.sysUsers.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseQuery;
import com.framework.v1.business.sysSetting.sysUsers.model.Sys_Perms_Group_ViewModel;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface PermsGroupViewService extends BaseQuery {




    JsonResult addOrEditPermsGroupView(@ModelAttribute Sys_Perms_Group_ViewModel sysPermsGroupViewModel) throws Exception;
}
