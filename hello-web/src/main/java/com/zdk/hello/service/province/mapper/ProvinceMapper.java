package com.zdk.hello.service.province.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdk.hello.service.province.entity.Province;

/**
 * <p>
 * 频道 Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2021-10-14
 */
public interface ProvinceMapper extends BaseMapper<Province> {

    /**
     * 分表场景使用:新增
     * @param province 新增实体
     * @return 影响条数
     */
    @Override
    int insert(Province province);
    
}
