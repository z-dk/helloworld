package com.zhudengkui.helloworld.user.controller;


import com.zhudengkui.helloworld.basemodel.PagingResponse;
import com.zhudengkui.helloworld.user.entity.User;
import com.zhudengkui.helloworld.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping("list")
    public PagingResponse<User> listUser(){
        PagingResponse<User> result = new PagingResponse<>();
        try {
            result.setRows(userService.list());
            result.setTotal(0);
            result.setFlag(true);
        } catch (Exception e){
            e.printStackTrace();
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}

