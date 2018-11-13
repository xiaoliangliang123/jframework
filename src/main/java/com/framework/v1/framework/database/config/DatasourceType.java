package com.framework.v1.framework.database.config;

public enum DatasourceType {

    read("read", "从库"),
    write("write", "主库");

    private String type;


    private String name;

    DatasourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
