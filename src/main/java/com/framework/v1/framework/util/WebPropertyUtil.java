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

    public static RemoteVister getRemoteVister(HttpServletRequest request) {
        RemoteVister remoteVister = RemoteVister.init(request);
        return remoteVister;
    }



}

class RemoteVister{

    private String ip ;
    private String host ;

    public RemoteVister(String ip,String host){
        this.ip = ip;
        this.host = host;
    }

    public static  RemoteVister  init(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        String host = request.getRemoteHost();
        RemoteVister remoteVister = new RemoteVister(ip,host);

        return remoteVister;
    }


    public String getIP() {
        return ip;
    }

    public String getHost() {
        return host;
    }
}
