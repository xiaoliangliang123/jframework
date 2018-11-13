package com.framework.v1.framework.database.base;

public class EmptyBaseModel  extends  BaseModel{

    @Override
    public Boolean isEmpty() {
        return true;
    }
}
