package com.framework.v1.business.common.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.base.service.BaseService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

public interface CommonService{


    JsonResult login(String username, String password) throws Exception;
}