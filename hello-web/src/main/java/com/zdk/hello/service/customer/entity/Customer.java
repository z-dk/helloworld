package com.zdk.hello.service.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zdk.hello.handler.EncryptStringTypeHandler;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author zdk
 * @since 2022-02-13
 */
@TableName(value = "customer", autoResultMap = true)
@ApiModel(value = "Customer对象", description = "客户信息表")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String customerName;

    private Long phone;

    /**
     * 地址,加密处理<br/>
     * 该注解仅对mybatisplus提供的基本方法生效,且需指明@TableName(autoResultMap = true)<br/>
     * 自定义sql仍需手动指定typehandler<br/>
     */
    @TableField(typeHandler = EncryptStringTypeHandler.class)
    private String address;

    private LocalDateTime birthday;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "id=" + id +
        ", customerName=" + customerName +
        ", phone=" + phone +
        ", address=" + address +
        ", birthday=" + birthday +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
