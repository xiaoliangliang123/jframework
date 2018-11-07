package com.database.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class ApiController {

    @RequestMapping("/login")
    @ResponseBody
    public String userInfo(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String username = request.getParameter("username");
        session.setAttribute("user",username);
        return "user";
    }

    @RequestMapping("/info")
    @ResponseBody
    public String getUserinfo(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String username = (String) session.getAttribute("user");

        return "username";
    }


}
