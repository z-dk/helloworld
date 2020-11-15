package design.strategy;

/**
 * <b>类 名 称</b> :  Context<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/15 22:14<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/15 22:14<br/>
 * <b>修改备注</b> :
 */
public class Context {
    
    private Strategy strategy;
    
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
