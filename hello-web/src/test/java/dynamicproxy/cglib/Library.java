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

    /**
     * @param num 购买数量
     * @return 是否购买成功
     */
    @SuppressWarnings("all")
    public boolean buyBook(int num){
        System.out.println("买书成功！"+num);
        return true;
    }
    
    public boolean sellBook(int num) {
        System.out.println("卖书成功！" + num);
        return true;
    }

    public static void aboutMe() {
        System.out.println("I'm a library interface");
    }

    public final void finalMethod() {
        System.out.println("I'm from Library, final");
    }

    private void privateMethod() {
        System.out.println("I'm private, only in Library");
    }
    
    @Override
    public String toString(){
        return "被代理的对象：" + getClass();
    }
    
}
