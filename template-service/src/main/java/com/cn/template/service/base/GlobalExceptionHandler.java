package com.cn.template.service.base;

import com.cn.template.common.bean.base.Response;
import com.cn.template.common.enums.ConfigConstant;
import com.cn.template.common.enums.ErrorContstant;
import com.cn.template.common.enums.ExceptionConstant;
import com.cn.template.common.exception.BusinessException;
import com.cn.template.common.exception.UnknownException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private BaseService baseService;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response result(Exception e) {
        ExceptionConstant.ExceptionEnum enums = ExceptionConstant.ExceptionEnum.getExceptions(e.getClass().getSimpleName());
        if (null == enums) {
            UnknownException unknownException = new UnknownException(ErrorContstant.ErrorEnum.UN_KNOW_ERROR);
            String message = unknownException.getMessage();
            if (ConfigConstant.ConfigEnum.APP_ENV.getValue().equals("dev")) {
                message = getStackTraceInfo(e);
            }
            return baseService.response(unknownException.getCode(), message);
        }
        switch (enums) {
            case BUSINESS_EXCEPTION:
                return baseService.response(((BusinessException) e).getCode(), e.getMessage());
            case UN_KNOW_EXCEPTION:
                return baseService.response(((UnknownException) e).getCode(), e.getMessage());
            case PARAM_CHECK_EXCEPTION:
                return baseService.response(ErrorContstant.ErrorEnum.PARAM_CHECK_ERROR.getErrorCode(),
                        Objects.requireNonNull(((MethodArgumentNotValidException) e).getBindingResult().getFieldError()).getDefaultMessage());
        }
        UnknownException unknownException = new UnknownException(ErrorContstant.ErrorEnum.UN_KNOW_ERROR);
        return baseService.response(unknownException.getCode(), unknownException.getMessage());
    }

    public static String getStackTraceInfo(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (Exception ex) {
            return "发生错误";
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
    }


}
