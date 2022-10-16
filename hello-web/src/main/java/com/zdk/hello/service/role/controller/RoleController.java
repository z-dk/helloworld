package com.zdk.hello.service.role.controller;


import com.zdk.hello.basemodel.Response;
import com.zdk.hello.service.role.entity.Role;
import com.zdk.hello.service.role.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zdk
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    
    private RoleService roleService;

    @PostMapping("get")
    public Response<Role> getRole(@RequestParam String id){
        Response<Role> result = new Response<>();
        result.setData(roleService.getRoleById(id));
        result.setCode(200);
        return result;
    }

    @Resource
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}

