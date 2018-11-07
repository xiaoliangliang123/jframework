package com.database.web.framework.database.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JModelDaoImpl implements JModelDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BaseModel selectModel(BaseModel baseModel) throws Exception{

        TableProperties tableProperties = TableProperties.loadColumnsAndKeys(jdbcTemplate,baseModel);

        baseModel = tableProperties.toSelectModelInstance(jdbcTemplate,baseModel);
        return baseModel;
    }

    @Override
    public BaseModel updateModel(BaseModel baseModel) throws Exception {
        TableProperties tableProperties = TableProperties.loadColumnsAndKeys(jdbcTemplate,baseModel);

        baseModel = tableProperties.toUpdateModelInstance(jdbcTemplate,baseModel);
        return baseModel;
    }

    @Override
    public BaseModel insertModel(BaseModel baseModel) throws Exception {
        TableProperties tableProperties = TableProperties.loadColumnsAndKeys(jdbcTemplate,baseModel);
        baseModel = tableProperties.toInsertModelInstance(jdbcTemplate,baseModel);
        return baseModel;
    }

    @Override
    public BaseModel deleteModel(BaseModel baseModel) throws Exception {
        TableProperties tableProperties = TableProperties.loadColumnsAndKeys(jdbcTemplate,baseModel);
        baseModel = tableProperties.toDeleteModelInstance(jdbcTemplate,baseModel);
        return baseModel;
    }
}
