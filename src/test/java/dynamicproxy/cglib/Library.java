package dynamicproxy.cglib;

/**
 * <b>类 名 称</b> :  Library<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 19:59<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 19:59<br/>
 * <b>修改备注</b> :
 */
public class Library {
    
    public boolean buyBook(int num){
        System.out.println("买书成功！"+num);
        return true;
    }
    
    @Override
    public String toString(){
        return "被代理的对象：" + getClass();
    }
    
}
