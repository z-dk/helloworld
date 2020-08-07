package com.zhudengkui.helloworld.user.service;

import com.zhudengkui.helloworld.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhudengkui.helloworld.user.entity.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public interface UserService extends IService<User> {
    
    public List<User> listUserByPage(UserVo userVo);
    
    public Integer countUserByPage(UserVo userVo);
    
}
