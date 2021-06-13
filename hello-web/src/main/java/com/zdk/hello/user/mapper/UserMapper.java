package com.zdk.hello.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.hello.user.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 方法描述: 统计数量
     * @return java.lang.Integer
     * @author zdk
     * <br/><b>创建时间:</b>2021/1/23 18:52
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2021/1/23 18:52
     * @since  1.0.0
     */
    @SuppressWarnings("unused")
    Integer count();
    
}
