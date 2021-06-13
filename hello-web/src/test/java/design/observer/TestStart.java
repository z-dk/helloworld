package design.observer;

/**
 * <b>类 名 称</b> :  TestStart<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/6/19 8:54<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/6/19 8:54<br/>
 * <b>修改备注</b> :
 */
public class TestStart {
    
    public static void main(String[] args) {
        ProductObservable observable = new ProductObservable();
        
        JingDongObserver jd = new JingDongObserver();
        TaoBaoObserver tb = new TaoBaoObserver();
        observable.addObserver(jd);
        observable.addObserver(tb);
        
        observable.addProduct("weixing");
        observable.deleteProduct("delete");
        
    }
    
}
