package com.framework.v1.framework.util;

import java.util.UUID;

public class GenerateUtil {

    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        return  uuid;
    }
}
