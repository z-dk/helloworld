package com.zdk.hello.service.role.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2021-07-18
 */
@Mapper
public interface RoleExtendMapper {

    /**
     * 查询角色数量
     * @return 返回数量
     */
    //@Select("select count(*) from `role`;")
    Integer count();

}
