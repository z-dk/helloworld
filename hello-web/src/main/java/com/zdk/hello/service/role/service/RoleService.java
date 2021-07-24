package com.zdk.hello.service.role.service;

import com.zdk.hello.service.role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zdk
 * @since 2021-07-18
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据角色主键id查询角色信息
     * @param id 角色id
     * @return 角色信息
     */
    Role getRoleById(String id);

}
