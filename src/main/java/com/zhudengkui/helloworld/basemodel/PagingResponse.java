package com.zhudengkui.helloworld.basemodel;

import java.util.List;

/**
 * <b>类 名 称</b> :  PagingResponse<br/>
 * <b>类 描 述</b> :  分页数据封装<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/1 17:17<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/1 17:17<br/>
 * <b>修改备注</b> :
 */
public class PagingResponse<T> {
    
    private Boolean flag;
    
    private String msg;
    
    private List<T> rows;
    
    private int total;
    
    public Boolean getFlag() {
        return flag;
    }
    
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public List<T> getRows() {
        return rows;
    }
    
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
}
