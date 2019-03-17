package com.framework.v1.business.common.controller;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.common.service.CommonService;
import com.framework.v1.business.sysUsers.vo.UserVO;
import com.framework.v1.framework.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(value = "/common")
public class UserCommonController {

    @Autowired
    private CommonService commonService;


    @RequestMapping(name="无权操作",value = "/noAuth")
    @ResponseBody
    public JsonResult noAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return new JsonResult(false,"您无权进行此操作");
    }

    @RequestMapping(name="用户登陆",value = "/login")
    @ResponseBody
    public JsonResult login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserVO userVO = (UserVO)SecurityUtils.getSubject().getPrincipal();
        if(StringUtil.isEmpty(userVO)){
            return  new JsonResult(false,"用户名或密码错误");
        }else {
            return  new JsonResult(true,"用户登陆成功");
        }
    }

    @RequestMapping(name="用户登陆成功",value = "/loginSuccess")
    @ResponseBody
    public JsonResult loginSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserVO userVO = (UserVO)SecurityUtils.getSubject().getPrincipal();
        if(StringUtil.isEmpty(userVO)){
            return  new JsonResult(false,"用户名或密码错误");
        }else {
            return  new JsonResult(true,"用户登陆成功");
        }
    }

}
