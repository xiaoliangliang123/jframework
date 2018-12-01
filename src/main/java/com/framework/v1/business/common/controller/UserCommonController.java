package com.framework.v1.business.common.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/common")
public class UserCommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(name="用户登陆",value = "/login")
    @ResponseBody
    public JsonResult userInfo(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JsonResult jsonResult = commonService.login(username,password);
        return jsonResult;
    }


}
