package com.framework.v1.business.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sys_user")
public class UserController {



    @Autowired
    private UserService userService;


    @RequestMapping(name = "添加用户" ,value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(String username,String password) throws Exception {


        //添加新系统用户
        JsonResult jsonResult = userService.addUser(username,password);
        return jsonResult;
    }

    @RequestMapping(name = "用户列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(String username) throws Exception {


        //添加新系统用户
        JsonResult jsonResult = userService.listUser(username);
        return jsonResult;
    }

    @RequestMapping(name = "初始化用户列表" ,value = "/init",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {


        //添加新系统用户
        JsonResult jsonResult = userService.baseList();
        return jsonResult;
    }
}
