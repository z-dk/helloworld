package com.zdk.hello.basemodel;

/**
 * <b>类 名 称</b> :  Encrypt<br/>
 * <b>类 描 述</b> :  加解密实体<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/2/13 9:37<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/2/13 9:37<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Encrypt<T> {
    
    private T value;

    public Encrypt() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Encrypt(T value) {
        this.value = value;
    }
}
