package com.framework.v1.framework.requestMapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class RequestMappingConfig {

    @Bean
    RequestMappingUtil getRequestMappingUtil(WebApplicationContext webApplicationContext){
        RequestMappingHandlerMapping rmhp = webApplicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods();
        List<Permission> permissions = new ArrayList<Permission>();
        for(RequestMappingInfo info : map.keySet()){

            HandlerMethod handlerMethod =  map.get(info);
            RequestMapping rm = (RequestMapping) handlerMethod.getMethodAnnotation(RequestMapping.class);
            if (rm != null) {
                RequestMethod[] rms = rm.method();
                String commont =  rm.name();
                for (RequestMethod r :rms){

                    String url = info.getPatternsCondition().getPatterns().iterator().next().toString();
                    String method = r.name();
                    permissions.add(new Permission(url,method,commont));
                }
            }
        }
        RequestMappingUtil rmutil = new RequestMappingUtil();
        rmutil.setPermissions(permissions);
        return  rmutil;
    }


}
