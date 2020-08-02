package com.zhudengkui.helloworld.user.mapper;

import com.zhudengkui.helloworld.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public interface UserMapper extends BaseMapper<User> {

    public Integer count();
    
}
