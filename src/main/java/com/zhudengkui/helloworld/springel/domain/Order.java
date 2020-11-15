package com.zhudengkui.helloworld.springel.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <b>类 名 称</b> :  Order<br/>
 * <b>类 描 述</b> :  springEL测试订单基础类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/14 10:26<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/14 10:26<br/>
 * <b>修改备注</b> :
 */
public class Order {
    
    private String userId;
    
    private Integer age;
    
    private Boolean newFlag;
    
    private LocalDate orderDate;
    
    private BigDecimal price;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Boolean getNewFlag() {
        return newFlag;
    }
    
    public void setNewFlag(Boolean newFlag) {
        this.newFlag = newFlag;
    }
    
    public LocalDate getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Order(String userId, Integer age, Boolean isNew, LocalDate orderDate, BigDecimal price) {
        this.userId = userId;
        this.age = age;
        this.newFlag = isNew;
        this.orderDate = orderDate;
        this.price = price;
    }
    
    public Order() {
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "userId='" + userId + '\'' +
                ", age=" + age +
                ", isNew=" + newFlag +
                ", orderDate=" + orderDate +
                ", price=" + price +
                '}';
    }
}
