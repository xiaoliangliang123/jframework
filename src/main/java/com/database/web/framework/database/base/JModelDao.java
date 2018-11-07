package com.database.web.framework.database.base;

import java.sql.SQLException;

public interface JModelDao {

    public  BaseModel selectModel(BaseModel baseModel) throws Exception;

    public  BaseModel updateModel(BaseModel baseModel) throws Exception;

    public  BaseModel insertModel(BaseModel baseModel) throws Exception;


}
