package com.zdk.hello.service.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdk.hello.service.user.entity.User;
import com.zdk.hello.service.user.entity.UserVo;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public interface UserService extends IService<User> {
    
    /**
     * 方法描述: 分页查询
     * @param userVo 查询参数
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.zdk.hello.service.user.entity.User>
     * @author zdk
     * <br/><b>创建时间:</b>2021/1/23 18:53
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2021/1/23 18:53
     * @since  1.0.0
     */
    Page<User> pageUserByParam(UserVo userVo);
    
    /**
     * 方法描述: 统计数据总量
     * @param userVo 请求参数
     * @return java.lang.Integer
     * @author zdk
     * <br/><b>创建时间:</b>2021/1/23 18:53
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2021/1/23 18:53
     * @since  1.0.0
     */
    @SuppressWarnings("unused")
    CompletableFuture<Long> countUserByPage(UserVo userVo);
    
    /**
     * 方法描述: 通过id获取用户数据
     * @param id 用户id
     * @return com.zdk.hello.service.user.entity.User
     * @author zdk
     * <br/><b>创建时间:</b>2021/1/24 17:37
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2021/1/24 17:37
     * @since  1.0.0
     */
    User getUserById(String id);
}
