package com.framework.v1.framework.security;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class ShiroConfiguration {
    //将自己的验证方式加入容器
    @Bean(value = "costomRealm")
    public CostomRealm myShiroRealm() {

        CostomRealm myShiroRealm = new CostomRealm();
        myShiroRealm.setCredentialsMatcher(new CredentialsMatcher());
        return myShiroRealm;
    }


    @Bean
    public AuthorizationFilter createAuthorizationFilter(){
        return new CustomRolesAuthorizationFilter();
    }


    //权限管理，配置主要是Realm的管理认证
    @Bean(value = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //登出
        map.put("/logout","logout");
        //对所有用户认证

//        map.put("/sub_admin/**", "authc,roles[\"SUB_ADMIN,ADMIN\"]");
//        map.put("/admin/**", "authc,roles[ADMIN]");
        map.put("/imgs/**", "anon");
        map.put("/lib/**", "anon");
        map.put("/index/**", "anon");
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        map.put("/common/loginSuccess", "anon");
        map.put("/common/noAuth", "anon");
        map.put("/common/login", "authc");
        map.put("/**", "roles");

        //登录
        shiroFilterFactoryBean.setLoginUrl("/common/login");

        shiroFilterFactoryBean.setSuccessUrl("/common/loginSuccess");
        Map<String,Filter> filterMap = new HashMap<String, Filter>();
        filterMap.put("roles",this.createAuthorizationFilter());

        shiroFilterFactoryBean.setFilters(filterMap);
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/common/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }


}

