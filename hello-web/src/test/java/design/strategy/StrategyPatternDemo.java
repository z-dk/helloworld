package design.strategy;

/**
 * <b>类 名 称</b> :  StrategyPatternDemo<br/>
 * <b>类 描 述</b> :  策略模式演示<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/15 22:15<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/15 22:15<br/>
 * <b>修改备注</b> :
 */
public class StrategyPatternDemo {
    
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        
        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
    
}
