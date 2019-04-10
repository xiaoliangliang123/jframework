package com.framework.v1.framework.database.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "sysConfigBean")
@PropertySource("classpath:application-dev.properties")
@ConfigurationProperties(prefix = "sys.config")
public class SysConfigBean {



    public static String getDatabaseType() {
        return databaseType;
    }

    public static boolean isMySql() {
        return "mysql".endsWith(databaseType);
    }

    public static boolean isOracle() {
        return "oracle".endsWith(databaseType);
    }

    public static boolean isSqlServer() {
        return "sqlServer".endsWith(databaseType);
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    private  static String databaseType;

    private String allowRequestAddress;

    private Boolean isAuth;

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public String getAllowRequestAddress() {
        return allowRequestAddress;
    }

    public void setAllowRequestAddress(String allowRequestAddress) {
        this.allowRequestAddress = allowRequestAddress;
    }

    public boolean isAuth() {
        return  this.getIsAuth();
    }
}
