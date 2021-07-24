package com.zdk.hello.service.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdk.hello.service.role.entity.Role;
import com.zdk.hello.service.role.mapper.RoleMapper;
import com.zdk.hello.service.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zdk
 * @since 2021-07-18
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Role getRoleById(String id) {
        LOGGER.info("根据id[{}]查询role,当前执行线程:{}", id, Thread.currentThread().getId());
        return getById(id);
    }
}
