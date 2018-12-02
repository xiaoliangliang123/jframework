package com.framework.v1.framework.error;


import com.framework.v1.business.base.model.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResult errorHandler(Exception e) {

        return new JsonResult(false,e.getMessage());
    }
}
