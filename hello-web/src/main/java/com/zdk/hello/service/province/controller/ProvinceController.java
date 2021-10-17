package com.zdk.hello.service.province.controller;


import com.zdk.hello.service.province.mapper.ProvinceExtendMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 频道 前端控制器
 * </p>
 *
 * @author zdk
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    
    @Resource
    ProvinceExtendMapper provinceExtendMapper;
    
    @RequestMapping("count")
    public Integer countAll() {
        return provinceExtendMapper.count();
    }

}

