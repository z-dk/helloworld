package com.zdk.hello.service.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdk.hello.basemodel.PagingResponse;
import com.zdk.hello.basemodel.Response;
import com.zdk.hello.service.user.entity.User;
import com.zdk.hello.service.user.entity.UserVo;
import com.zdk.hello.service.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
    
    @Resource
    UserService userService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("list")
    public PagingResponse<User> listUser(@RequestBody UserVo userVo){
        PagingResponse<User> result = new PagingResponse<>();
        Page<User> page = userService.pageUserByParam(userVo);
        result.setRows(page.getRecords());
        result.setTotal((int) page.getTotal());
        result.setFlag(true);
        return result;
    }
    
    @PostMapping("count")
    public Response getCount(@RequestBody UserVo userVo) throws ExecutionException, InterruptedException {
        Response result = new Response();
        CompletableFuture<Long> countFuture = userService.countUserByPage(userVo);
        result.setData(countFuture.get());
        result.setFlag(true);
        result.setCode(200);
        return result;
    }
    
    @GetMapping("get")
    public Response getUser(@RequestParam String id) {
        Response result = new Response();
        User user = userService.getUserById(id);
        result.setData(user);
        result.setFlag(true);
        result.setCode(200);
        return result;
    }

}

