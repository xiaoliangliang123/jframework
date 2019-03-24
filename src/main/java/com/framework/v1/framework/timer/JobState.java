package com.framework.v1.framework.timer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

public class JobState {



    public static final Integer STATE_RUNNING =   1;
    public static final Integer STATE_SHUTDOWN =   0;

    private int state = 0 ;



    public JobState(int state){
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public static JobState initState(Integer state) {
        return new JobState(state);
    }

    public static JobState initState(boolean isRunning) {
        if(isRunning){
            return new JobState(STATE_RUNNING);
        }else {
            return new JobState(STATE_SHUTDOWN);
        }
    }
}
