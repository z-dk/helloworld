package com.zdk.hello.mapper.helloworld;

import com.zdk.hello.annotations.TargetDataSource;
import com.zdk.hello.service.province.entity.Province;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 频道 Mapper 接口
 * </p>
 * mapper.xml未生效问题解决:<br/>
 * @see com.zdk.hello.config.DataSourceConfig 中自定义了SqlSessionFactory,而自定义的是MybatisSqlSessionFactoryBean,没有指定其mapperLocations属性
 * 即未指定mapper-locations: classpath*:config/***.xml,mybatisPlus的配置文件将其配置在了MybatisPlusProperties,没有加载到,
 * 故一直报错找不到org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
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
    //@Select("select count(*) from province;")
    Integer count();
    
}
