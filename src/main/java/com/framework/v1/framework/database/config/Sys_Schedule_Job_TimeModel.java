package com.framework.v1.framework.database.config;

import com.framework.v1.framework.database.base.BaseModel;

public class Sys_Schedule_Job_TimeModel extends BaseModel {



    private String id;
    private String job_id;
    private String use_time;
    private String time ;

    public String getExecute_type() {
        return execute_type;
    }

    public void setExecute_type(String execute_type) {
        this.execute_type = execute_type;
    }

    private String execute_type ;
    private String result;
    private String job_class ;

    public String getJob_class() {
        return job_class;
    }

    public void setJob_class(String job_class) {
        this.job_class = job_class;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getUse_time() {
        return use_time;
    }

    public void setUse_time(String use_time) {
        this.use_time = use_time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
