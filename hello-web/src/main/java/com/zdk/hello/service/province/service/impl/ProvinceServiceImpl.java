package com.zdk.hello.service.province.service.impl;

import com.zdk.hello.service.province.entity.Province;
import com.zdk.hello.mapper.helloworld.ProvinceExtendMapper;
import com.zdk.hello.mapper.helloworld.ProvinceMapper;
import com.zdk.hello.service.province.service.ProvinceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 频道 服务实现类
 * </p>
 *
 * @author zdk
 * @since 2021-10-14
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Resource
    ProvinceExtendMapper provinceExtendMapper;

}
