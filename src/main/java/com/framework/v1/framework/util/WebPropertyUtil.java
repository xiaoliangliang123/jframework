package com.framework.v1.framework.util;

import com.framework.v1.business.sysUsers.vo.UserVO;
import org.apache.shiro.SecurityUtils;

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

    private String time;
    private String ip ;
    private String host ;
    private String username ;
    private String url ;


    public RemoteVister(String username,String url,String ip,String host,String time){
        this.ip = ip;
        this.host = host;
        this.username = username;
        this.url = url;
        this.time = time ;
    }

    public String getTime() {
        return time;
    }

    public static  RemoteVister  init(HttpServletRequest request){

        UserVO userVO = (UserVO) SecurityUtils.getSubject().getPrincipal();
        String ip = request.getRemoteAddr();
        String host = request.getRemoteHost();
        String url = request.getRequestURL().toString();
        String time = GenerateUtil.currentTime();
        String username ="";
        if(userVO!=null){
            username = userVO.getSysUserModel().getUsername();
        }
        RemoteVister remoteVister = new RemoteVister(username,url,ip,host,time);

        return remoteVister;
    }


    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public String getIP() {
        return ip;
    }

    public String getHost() {
        return host;
    }
}
