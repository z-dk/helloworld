package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>类 名 称</b> :  ReentrantLockTest<br/>
 * <b>类 描 述</b> :  ReentrantLock<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/7 22:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/7 22:25<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ReentrantLockTest {
    
    public static void main(String[] args) {
        
    }
    
    public static void test() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
        condition.signal();
    }
    
}
