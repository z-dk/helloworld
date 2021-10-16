package com.zdk.hello.service.province.mapper;

import com.zdk.hello.service.province.entity.Province;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 频道 Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2021-10-14
 */
@Mapper
public interface ProvinceExtendMapper {

    /**
     * 分表场景使用:新增
     * /// @Insert("insert into province value (#{id}, #{provinceId}, #{provinceName}, #{cityId}, #{cityName});")
     * @param province 新增实体
     * @return 影响条数
     */
    int insertProvince(Province province);

}
