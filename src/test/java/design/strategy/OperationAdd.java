package design.strategy;

/**
 * <b>类 名 称</b> :  OperatorAdd<br/>
 * <b>类 描 述</b> :  加运算<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/15 22:12<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/15 22:12<br/>
 * <b>修改备注</b> :
 */
public class OperationAdd implements Strategy{
    
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
