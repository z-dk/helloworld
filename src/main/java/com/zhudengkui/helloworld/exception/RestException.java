package com.zhudengkui.helloworld.exception;

/**
 * <b>类 名 称</b> :  RestException<br/>
 * <b>类 描 述</b> :  远程调用异常<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 16:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 16:25<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class RestException extends RuntimeException {
    
    private static final long serialVersionUID = -5351979193422689359L;
    
    public RestException(String message) {
        super(message);
    }
    
}
