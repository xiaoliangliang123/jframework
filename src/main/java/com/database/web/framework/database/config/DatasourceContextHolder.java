package com.database.web.framework.database.config;

public class DatasourceContextHolder {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {

        local.set(DatasourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        local.set(DatasourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }



}
