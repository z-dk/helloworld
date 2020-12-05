package com.zhudengkui.helloworld.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhudengkui.helloworld.basemodel.PagingResponse;
import com.zhudengkui.helloworld.user.entity.User;
import com.zhudengkui.helloworld.user.entity.UserVo;
import com.zhudengkui.helloworld.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public PagingResponse<User> listUser(@RequestBody UserVo userVo, @RequestParam Map<String,String> param){
        PagingResponse<User> result = new PagingResponse<>();
        try {
            System.out.println(param.toString());
            Page<User> page = userService.pageUserByParam(userVo);
            result.setRows(page.getRecords());
            result.setTotal((int) page.getTotal());
            result.setFlag(true);
        } catch (Exception e){
            e.printStackTrace();
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}

