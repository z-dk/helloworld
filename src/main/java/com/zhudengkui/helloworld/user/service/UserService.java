package com.zhudengkui.helloworld.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhudengkui.helloworld.user.entity.User;
import com.zhudengkui.helloworld.user.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public interface UserService extends IService<User> {
    
    public Page<User> pageUserByParam(UserVo userVo);
    
    public Integer countUserByPage(UserVo userVo);
    
}
