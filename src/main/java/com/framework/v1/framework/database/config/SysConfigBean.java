package com.framework.v1.framework.database.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "sysConfigBean")
@PropertySource("classpath:application-dev.properties")
@ConfigurationProperties(prefix = "sys.config")
public class SysConfigBean {

    private String allowRequestAddress;

    public String getAllowRequestAddress() {
        return allowRequestAddress;
    }

    public void setAllowRequestAddress(String allowRequestAddress) {
        this.allowRequestAddress = allowRequestAddress;
    }
}
