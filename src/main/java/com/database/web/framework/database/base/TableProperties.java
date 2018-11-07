package com.database.web.framework.database.base;

import com.database.web.framework.util.StringUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TableProperties {

    private String tableName;
    private List<String> pkeys;
    private List<String> columns;
    private List<String> colValues;

    public List<String> getColValues() {
        return colValues;
    }

    public List<String> getPkValues() {
        return pkValues;
    }

    private List<String> pkValues;

    public List<String> getPkeys() {
        return pkeys;
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public static TableProperties loadColumnsAndKeys(JdbcTemplate jdbcTemplate, BaseModel baseModel) throws SQLException, IllegalAccessException {

        DatabaseMetaData dbMetaData = jdbcTemplate.getDataSource().getConnection().getMetaData();

        TableProperties tableProperties = new TableProperties();
        String tableName = getTableName(baseModel);
        tableProperties.setTableName(tableName);

        ResultSet colRet = dbMetaData.getColumns(null, "%", tableName, "%");

        ResultSet primaryKeys = dbMetaData.getPrimaryKeys(null, null, tableName);


        List<String> pkeys = new ArrayList<>();
        //获取主键信息
        while (primaryKeys.next()) {
            pkeys.add(primaryKeys.getString(4));
        }
        tableProperties.setPKeys(pkeys);
        List<String> columns = getColumns(tableProperties, baseModel);
        tableProperties.setColumns(columns);
        List<String> pkValues = getPkValues(tableProperties, baseModel);
        tableProperties.setPkValues(pkValues);

        List<String> colValues = getColValues(tableProperties, baseModel);
        tableProperties.setColValues(colValues);

        return tableProperties;

    }

    private static List<String> getColValues(TableProperties tableProperties, BaseModel baseModel) throws IllegalAccessException {
        List<String> colValues = new ArrayList<>();
        Class baseModelClass = baseModel.getClass();
        Field[] fields = baseModelClass.getDeclaredFields();

        // 循环遍历字段，获取字段相应的属性值
        for (Field field : fields) {
            // 假设不为空。设置可见性，然后返回
            field.setAccessible(true);
            String name = field.getName();
            if(!tableProperties.getPkeys().contains(name)) {
                String colvalue = (String) field.get(baseModel);
                colValues.add(colvalue);
            }
        }
        return colValues;
    }

    public void setColValues(List<String> colValues) {
        this.colValues = colValues;
    }

    private static List<String> getColumns(TableProperties tableProperties, BaseModel baseModel) {

        List<String> columns = new ArrayList<>();
        Class baseModelClass = baseModel.getClass();
        System.out.println(baseModelClass.getName());
        Field[] fields = baseModelClass.getDeclaredFields();

        // 循环遍历字段，获取字段相应的属性值
        for (Field field : fields) {
            // 假设不为空。设置可见性，然后返回
            field.setAccessible(true);
            String name = field.getName();
            if(!tableProperties.getPkeys().contains(name)) {
                columns.add(name);
            }
        }
        return columns;
    }

    private static String getTableName(BaseModel baseModel) {
        Class baseModelClass = baseModel.getClass();
        String fullname = baseModelClass.getName();
        String[] names = fullname.split("\\.");
        String tableModelName = names[names.length - 1];
        Integer tableNameIndex = tableModelName.lastIndexOf("Model");
        String tableName = tableModelName.substring(0, tableNameIndex);
        return tableName.toLowerCase();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setPKeys(List<String> pkeys) {
        this.pkeys = pkeys;
    }


    public BaseModel toSelectModelInstance(JdbcTemplate jdbcTemplate, BaseModel baseModel) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        String sql = retrunSelectSql();

        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, pkValues.toArray());

        if (mapList == null || mapList.isEmpty()) {
            return null;
        }
        baseModel = newModelInstance(mapList.get(0), baseModel);
        return baseModel;
    }

    public BaseModel toUpdateModelInstance(JdbcTemplate jdbcTemplate, BaseModel baseModel) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        String sql = retrunUpdateSql();
        colValues.removeAll(Collections.singleton(null));
        colValues.addAll(pkValues);
        int updateRows = jdbcTemplate.update(sql,colValues.toArray());

        if (updateRows == 0) {
            return null;
        }
        return baseModel;
    }

    public BaseModel toInsertModelInstance(JdbcTemplate jdbcTemplate, BaseModel baseModel) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        String sql = retrunInsertSql();
        colValues.removeAll(Collections.singleton(null));
        colValues.addAll(pkValues);
        int updateRows = jdbcTemplate.update(sql,colValues.toArray());

        if (updateRows == 0) {
            return null;
        }
        return baseModel;
    }

    private String retrunInsertSql() {
        boolean isSet = false;
        StringBuilder stringBuilder = new StringBuilder(" insert into  " + this.tableName);
        for (int i = 0; i < columns.size(); i++) {
            if(!StringUtil.isEmpty(colValues.get(i))&&!pkeys.contains(columns.get(i))) {
                if(!isSet) {
                    stringBuilder.append(" ( " + columns.get(i) + " , ");
                    isSet = true;
                }else {
                    stringBuilder.append("  " + columns.get(i) + "  ");
                }
            }
        }
        stringBuilder.append(" )  values ( ");
        for (int i = 0; i < colValues.size(); i++) {
            if(i !=colValues.size()) {
                stringBuilder.append("  " + colValues.get(i) + " , ");
            }else {
                stringBuilder.append("  " + colValues.get(i) + "  ");
            }
        }
        stringBuilder.append(" ) ");
        return stringBuilder.toString();
    }

    private String retrunUpdateSql() {
        boolean isSet = false;
        StringBuilder stringBuilder = new StringBuilder(" update " + this.tableName);
        for (int i = 0; i < columns.size(); i++) {
            if(!StringUtil.isEmpty(colValues.get(i))&&!pkeys.contains(columns.get(i))) {
                if(!isSet) {
                    stringBuilder.append(" set " + columns.get(i) + " = ? ");
                    isSet = true;
                }else {
                    stringBuilder.append(" , " + columns.get(i) + " = ?");
                }
            }
        }
        stringBuilder.append(" where ");
        for (int i = 0; i < pkeys.size(); i++) {
            if (i == 0) {
                stringBuilder.append(" " + pkeys.get(i) + " = ?");
            } else {
                stringBuilder.append(" and " + pkeys.get(i) + " = ?");
            }
        }
        return stringBuilder.toString();
    }

    private BaseModel newModelInstance(Map<String, Object> map, BaseModel baseModel) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class baseModelClass = baseModel.getClass();
        Class clazz = Class.forName(baseModelClass.getName());
        Object obj = clazz.newInstance();
        for (int i = 0; i < columns.size(); i++) {
            Field field = clazz.getDeclaredField(columns.get(i));
            field.setAccessible(true);
            field.set(obj, map.get(columns.get(i)));
        }
        return (BaseModel) obj;
    }

    private String retrunSelectSql() {
        StringBuilder stringBuilder = new StringBuilder("select * from " + this.tableName);
        stringBuilder.append(" where ");
        for (int i = 0; i < pkeys.size(); i++) {
            if (i == 0) {
                stringBuilder.append(" " + pkeys.get(i) + " = ?");
            } else {
                stringBuilder.append(" and " + pkeys.get(i) + " = ?");
            }
        }
        return stringBuilder.toString();
    }

    private static List<String> getPkValues(TableProperties tableProperties, BaseModel baseModel) throws IllegalAccessException {
        List<String> pkValues = new ArrayList<>();
        Class baseModelClass = baseModel.getClass();
        System.out.println(baseModelClass.getName());
        Field[] fields = baseModelClass.getDeclaredFields();

        // 循环遍历字段，获取字段相应的属性值
        for (Field field : fields) {
            // 假设不为空。设置可见性，然后返回
            field.setAccessible(true);
            String name = field.getName();
            if (tableProperties.getPkeys().contains(name)) {
                String pkvalue = (String) field.get(baseModel);
                pkValues.add(pkvalue);
            }
        }
        return pkValues;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public void setPkValues(List<String> pkValues) {
        this.pkValues = pkValues;
    }
}
