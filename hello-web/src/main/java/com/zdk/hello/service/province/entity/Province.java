package com.zdk.hello.service.province.entity;

import java.io.Serializable;

/**
 * <p>
 * 频道
 * </p>
 *
 * @author zdk
 * @since 2021-10-14
 */
public class Province implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer provinceId;

    private Integer cityId;

    private String provinceName;

    private String cityName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Province{" +
        "id=" + id +
        ", provinceId=" + provinceId +
        ", cityId=" + cityId +
        ", provinceName=" + provinceName +
        ", cityName=" + cityName +
        "}";
    }
}
