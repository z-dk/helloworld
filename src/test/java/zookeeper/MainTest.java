package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <b>类 名 称</b> :  MainTest<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/7/25 21:38<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/7/25 21:38<br/>
 * <b>修改备注</b> :
 */
public class MainTest {
    
    private static final String ZK_ADD = "127.0.0.1:2181";
    
    private static final int TIME_OUT = 5000;
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        
        ZooKeeper zooKeeper = new ZooKeeper(ZK_ADD, TIME_OUT, watchedEvent -> {
            Watcher.Event.KeeperState state = watchedEvent.getState();
            if (state == Watcher.Event.KeeperState.SyncConnected) {
                System.out.println("zk连接成功");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        String s = zooKeeper.create("/zdk", "zdk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    
        List<String> children = zooKeeper.getChildren("/", false);
        System.out.println(children);
        zooKeeper.close();
    }
    
}
