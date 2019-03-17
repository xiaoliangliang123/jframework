package com.framework.v1.framework.error;

public class NoLoginException  extends Exception {

    private static final long serialVersionUID = -6925278824391495117L;


    public NoLoginException(){
        super("401");
    }
    public NoLoginException(String message) {
        super(message);
    }

}
