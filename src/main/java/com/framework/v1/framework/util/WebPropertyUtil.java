package com.framework.v1.framework.util;

import com.framework.v1.business.sysUsers.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebPropertyUtil {


    public static String PROPERTY_USER = "SYS_USER";

    public static void setUser(HttpServletRequest request, UserVO userVO) {

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(PROPERTY_USER,userVO);
    }
}
