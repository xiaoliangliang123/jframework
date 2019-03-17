package com.framework.v1.business.sysUsers.controller;


import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.business.sysUsers.service.PermsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys_user")
public class PermsUserController {



    @Autowired
    private PermsUserService userService;

    @RequestMapping(name = "获取用户信息" ,value = "/getUserinfo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getUserinfo(String userid) throws Exception {


        //获取系统用户信息
        JsonResult jsonResult = userService.getUserinfo(userid);
        return jsonResult;
    }

    @RequestMapping(name = "添加或编辑用户" ,value = "/addOrEdit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(String userid,String username,String nickname) throws Exception {


        //添加新系统用户
        JsonResult jsonResult = userService.addOrEditUser(userid,username,nickname);
        return jsonResult;
    }


    @RequestMapping(name = "用户列表" ,value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list() throws Exception {

        //添加新系统用户
        JsonResult jsonResult = userService.baseList();
        return jsonResult;
    }

    @RequestMapping(name = "删除用户" ,value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult del(String userId) throws Exception {



        //添加新系统用户
        JsonResult jsonResult = userService.removeUser(userId);
        return jsonResult;
    }
}
