package design.observer;

import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <b>类 名 称</b> :  ProductObservable<br/>
 * <b>类 描 述</b> :  生产者，被观察者<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/6/19 8:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/6/19 8:31<br/>
 * <b>修改备注</b> :
 */
public class ProductObservable extends Observable {
    
    private CopyOnWriteArrayList<String> productList = new CopyOnWriteArrayList<>();
    
    public void addProduct(String product){
        productList.add(product);
        setChanged();
        notifyObservers(productList);
    }
    
    public void deleteProduct(String product){
        productList.remove(product);
        setChanged();
        notifyObservers(productList);
    }
    
}
