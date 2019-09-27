package com.zhudengkui.helloword.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>类 名 称</b> :  HelloController<br/>
 * <b>类 描 述</b> :  springboot测试<br/>
 * <b>创 建 人</b> :  朱登奎<br/>
 * <b>创建时间</b> :  2019/9/3 9:57<br/>
 * <b>修 改 人</b> :  朱登奎<br/>
 * <b>修改时间</b> :  2019/9/3 9:57<br/>
 * <b>修改备注</b> :  
 */

@RestController
public class HelloController {
    
    @RequestMapping("/helloworld")
    public String hello(){
        return "hello world";
    }
    
}
