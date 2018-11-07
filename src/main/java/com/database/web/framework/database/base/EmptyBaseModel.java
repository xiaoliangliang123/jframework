package com.database.web.framework.database.base;

public class EmptyBaseModel  extends  BaseModel{

    @Override
    public Boolean isEmpty() {
        return true;
    }
}
