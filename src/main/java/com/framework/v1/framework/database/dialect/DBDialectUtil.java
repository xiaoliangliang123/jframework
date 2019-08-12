package com.framework.v1.framework.database.dialect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBDialectUtil {

    @Autowired
    private List<DBDialect> dbDialects;

    public List<DBDialect> getDbDialects() {
        return dbDialects;
    }


    public DBDialect getDbDialect(String databaseType) {

        for (DBDialect dbDialect:dbDialects){
            if(dbDialect.isMyDo(databaseType)){
                return dbDialect;
            }
        }
        return null;
    }
}
