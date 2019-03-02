package com.framework.v1.framework.util;

import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
}
