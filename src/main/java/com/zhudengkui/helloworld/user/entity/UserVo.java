package com.zhudengkui.helloworld.user.entity;

import com.zhudengkui.helloworld.basemodel.Paging;

import java.io.Serializable;

/**
 * <b>类 名 称</b> :  UserVo<br/>
 * <b>类 描 述</b> :  查询参数<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/2 16:55<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/2 16:55<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
public class UserVo extends Paging implements Serializable {
    
    private static final long serialVersionUID = 5976641017960190070L;
    
    private User user = new User();
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
