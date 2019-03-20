package com.framework.v1.framework.database.config;

import com.framework.v1.framework.security.CredentialsMatcher;
import com.framework.v1.framework.security.CustomRolesAuthorizationFilter;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListener {

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        DefaultWebSecurityManager manager = (DefaultWebSecurityManager) context.getBean("securityManager");
        AuthorizingRealm realm = (AuthorizingRealm) context.getBean("costomRealm");
        realm.setCredentialsMatcher(new CredentialsMatcher());
        manager.setRealm(realm);
    }
}
