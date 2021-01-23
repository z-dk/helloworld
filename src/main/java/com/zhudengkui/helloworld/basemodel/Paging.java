package com.zhudengkui.helloworld.basemodel;

/**
 * <b>类 名 称</b> :  Paging<br/>
 * <b>类 描 述</b> :  分页参数<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/2 16:57<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/2 16:57<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
public class Paging {
    
    private Boolean pagingFlag = true;
    
    private Integer page = 1;
    
    private Integer rows = 10;
    
    public Boolean getPagingFlag() {
        return pagingFlag;
    }
    
    public void setPagingFlag(Boolean pagingFlag) {
        this.pagingFlag = pagingFlag;
    }
    
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getRows() {
        return rows;
    }
    
    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
