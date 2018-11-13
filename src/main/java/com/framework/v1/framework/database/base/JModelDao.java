package com.framework.v1.framework.database.base;

public interface JModelDao {

    public  BaseModel selectModel(BaseModel baseModel) throws Exception;

    public  BaseModel updateModel(BaseModel baseModel) throws Exception;

    public  BaseModel insertModel(BaseModel baseModel) throws Exception;

    public  BaseModel deleteModel(BaseModel baseModel) throws Exception;


}
