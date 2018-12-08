package com.framework.v1.framework.util;

import java.util.Map;

public class StringUtil {

    public static boolean isEmpty(String s) {
        if(s!=null&&!s.equals("")&&!s.isEmpty()&&!s.equals("null")){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Object s) {
        if(s!=null&&!s.equals("")){
            return false;
        }
        return true;
    }


    public static boolean isEmpty(String[] s) {
        if(s!=null&&s.length!=0&&!isEmpty(s[0])){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Map s) {
        if(s!=null&&!s.isEmpty()){
            return false;
        }
        return true;
    }
}
