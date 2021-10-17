package com.zdk.hello.service.province.mapper;

import com.zdk.hello.annotations.TargetDataSource;
import com.zdk.hello.service.province.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 频道 Mapper 接口
 * </p>
 * todo mapper.xml未生效
 * @author zdk
 * @since 2021-10-14
 */
@Mapper    
@TargetDataSource(name = TargetDataSource.HELLO_WORLD_SHARDING)
public interface ProvinceExtendMapper {

    /**
     * 分表场景使用:新增
     * /// @Insert("insert into province value (#{id}, #{provinceId}, #{cityId}, #{provinceName}, #{cityName});")
     * @param province 新增实体
     * @return 影响条数
     */
    Integer insertProvince(Province province);

    /**
     * 统计记录数
     * @return 返回总记录数
     */
    @Select("select count(*) from province;")
    Integer count();
    
}
