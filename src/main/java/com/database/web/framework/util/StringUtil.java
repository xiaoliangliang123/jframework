package com.database.web.framework.util;

public class StringUtil {

    public static boolean isEmpty(String s) {
        if(s!=null&&!s.equals("")&&!s.isEmpty()){
            return false;
        }
        return true;
    }
}
