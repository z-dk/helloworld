package com.zhudengkui.helloworld.handler;

import com.zhudengkui.helloworld.basemodel.Response;
import com.zhudengkui.helloworld.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <b>类 名 称</b> :  GlobleExceptionHandler<br/>
 * <b>类 描 述</b> :  全局异常处理<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 16:21<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 16:21<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        LOGGER.error("全局异常处理：", e);
        Response response = new Response();
        response.setFlag(false);
        response.setCode(500);
        if (e instanceof RestException) {
            response.setMsg("网络异常，请稍后重试！");
        } else {
            response.setMsg("咦，遇到问题了~_~");
        }
        return response;
    }
    
}
