package com.framework.v1.business.base.service;

import com.framework.v1.business.base.model.JsonResult;
import com.framework.v1.framework.database.base.BaseDao;
import com.framework.v1.framework.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public abstract class BaseService extends BaseDao {


    public JsonResult baseList() throws Exception {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map map = request.getParameterMap();

        PageInfo pageInfo = PageInfo.init(map);
        Map qps =  getQueryParams(map);
        String sql =  baseQuery();
        sql = wapperSqlInWhere(qps,sql);
        String countSql ="select count(*)  _totalCount from ("+sql+")xx_count";
        String limitSql = pageInfo.toLimitSql(sql);
        Map countMap = new HashMap() ;
        if(StringUtil.isEmpty(qps)) {
             countMap = getjBaseDao().getJdbcTemplate().queryForMap(countSql);
        }else {
            countMap = getjBaseDao().getJdbcTemplate().queryForMap(countSql,qps.values().toArray());
        }
        int totalCount = Integer.parseInt(countMap.get("_totalCount").toString());
        List<Map<String,Object>> mapList = new ArrayList<>();
        if(StringUtil.isEmpty(qps)){
            mapList = getjBaseDao().queryForList(limitSql);
        }else {
            mapList = getjBaseDao().queryForList(limitSql,qps.values().toArray());
        }
        return new JsonResult(mapList,(int)totalCount,1,0);
    }

    protected  String wapperSqlInWhere(Map qps,String sql){

        StringBuffer whereSql = new StringBuffer(" where 1=1 ");
        Set<Map.Entry> entrySet =qps.entrySet();
        Iterator<Map.Entry> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry entry = entryIterator.next();
            String val = entry.getValue().toString();
            String key = entry.getKey().toString();
            if(key.startsWith(BaseQuery.LIKE)){
                whereSql.append(" and ").append(key.replaceFirst(BaseQuery.LIKE,"")).append(" like ? ");
                qps.put(key,"%"+val+"%");
            }else if(key.startsWith(BaseQuery.EQUAL)){
                whereSql.append(" and ").append(key.replaceFirst(BaseQuery.EQUAL,"")).append(" = ? ");
            }
        }
        return sql+ whereSql.toString();
    }

    protected Map getQueryParams(Map map){
        Map queryMap = new HashMap();
        Set<Map.Entry> entrySet =map.entrySet();
        Iterator<Map.Entry> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Map.Entry entry = entryIterator.next();
            if(entry.getKey().equals(BaseQuery.PAGE_INFO)||((entry.getKey().toString().startsWith(BaseQuery.EQUAL))
                    &&(entry.getKey().toString().startsWith(BaseQuery.LIKE)))){
                continue;
            }
            Object val = entry.getValue();
            if(val instanceof String[]){
                if(StringUtil.isEmpty((String[])val)){
                    continue;
                }else {
                    queryMap.put(entry.getKey(),((String[])val)[0]);
                }
            }else if(val instanceof String){
                if(!StringUtil.isEmpty(val.toString())){
                    queryMap.put(entry.getKey(),val);
                }
            }

        }
        return queryMap;
    }

    public abstract String baseQuery() ;


}
