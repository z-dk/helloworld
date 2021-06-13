package com.zdk.hello.basemodel;

/**
 * <b>类 名 称</b> :  Response<br/>
 * <b>类 描 述</b> :  返回结果封装类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/1 17:15<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/1 17:15<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
public class Response {
    
    private Boolean flag;
    
    private String msg;
    
    private Object data;
    
    private Integer code;
    
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
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
}
