package design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>类 名 称</b> :  Meal<br/>
 * <b>类 描 述</b> :  meal<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 14:28<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 14:28<br/>
 * <b>修改备注</b> :
 */
public class Meal {
    
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }
    
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
    
}
