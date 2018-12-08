package com.framework.v1.business.base.service;

import com.framework.v1.business.base.model.JsonResult;

public interface BaseQuery  {

    JsonResult baseList() throws Exception ;

    public static final String PAGE_INFO= "pageInfo";


    public static final String LIKE= "like_";

    public static final String EQUAL= "eq_";

}
