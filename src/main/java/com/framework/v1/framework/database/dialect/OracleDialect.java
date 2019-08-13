package com.framework.v1.framework.database.dialect;

import com.framework.v1.business.base.service.PageInfo;
import org.springframework.stereotype.Component;

@Component
public class OracleDialect extends DBDialect {

    @Override
    public String myDialect() {
        return DIALECT_ORACLE;
    }

    @Override
    public String pageSql() {
        return null;
    }

}
