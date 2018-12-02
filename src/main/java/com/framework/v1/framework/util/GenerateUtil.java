package com.framework.v1.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GenerateUtil {

    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        return  uuid;
    }


    public static String currentTime() {

        Date date = new Date();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String time = sdformat.format(date);
        return time;
    }

}
