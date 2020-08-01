package com.zhudengkui.helloworld.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zdk
 * @since 2020-08-01
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime create_time;

    private LocalDateTime update_time;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", remark=" + remark +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        "}";
    }
}
