package com.framework.v1.framework.util;

import com.framework.v1.business.sysUsers.vo.SysPermsGroupUrlVO;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataUtil {
    public static List<String> getStringListForKey(String key, List<Map> mapList) {

        List<String> urls = new ArrayList<>();
        if(StringUtil.isEmpty(mapList)){
            return urls;
        }
        for(Map map:mapList){

            String url = (String) map.get(key);
            urls.add(url);
        }
        return urls;
    }

    public static <T> List<T> copyListMap2ListBean(List<Map> allPermsGroupModels, Class<T> objclass) throws Exception{
        if(StringUtil.isEmpty(allPermsGroupModels)){
            return null;
        }
        List<T> tlist = new ArrayList<>();
        for(Map m:allPermsGroupModels){
            T bean = copyMap2Bean(m,objclass);
            tlist.add(bean);
        }
        return tlist;
    }

    public static <T> T copyMap2Bean(Map m, Class<T> objclass) throws Exception {
        T bean =  objclass.newInstance();
        BeanUtils.populate(bean, m);
        return bean;
    }

    public static <T> Map<String,List<T>> groupBy(List<T> objList,Function<String,String>  getName) {
        return  null;
    }
}
