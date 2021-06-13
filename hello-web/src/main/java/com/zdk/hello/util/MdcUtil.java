package com.zdk.hello.util;

import org.slf4j.MDC;

/**
 * <b>类 名 称</b> :  MDCUtil<br/>
 * <b>类 描 述</b> :  MDC工具类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 16:01<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 16:01<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class MdcUtil {
    
    private static final String TRACE_ID = "TRACE_ID";
    
    public static String get() {
        return MDC.get(TRACE_ID);
    }
    
    public static void add(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }
    
}
