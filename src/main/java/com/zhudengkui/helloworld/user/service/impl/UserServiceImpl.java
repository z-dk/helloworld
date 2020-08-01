package com.zhudengkui.helloworld.user.service.impl;

import com.zhudengkui.helloworld.user.entity.User;
import com.zhudengkui.helloworld.user.mapper.UserMapper;
import com.zhudengkui.helloworld.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
