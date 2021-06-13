package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);
    
    private static final String ZK_ADD = "39.107.107.102:2181";
    
    private static final int TIME_OUT = 5000;
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper = null;

    static {
        try {
            zooKeeper = new ZooKeeper(ZK_ADD, TIME_OUT, watchedEvent -> {
                Watcher.Event.KeeperState state = watchedEvent.getState();
                switch (state){
                    case SyncConnected:
                        LOGGER.info("zk连接成功");
                        countDownLatch.countDown();
                        break;
                    case ConnectedReadOnly:
                        LOGGER.info("连接到只读客户端");
                        break;
                    case AuthFailed:
                        LOGGER.info("认证失败");
                        break;
                    case SaslAuthenticated:
                        LOGGER.info("认证成功");
                        break;
                    case Expired:
                        LOGGER.info("连接已过期");
                        break;
                    case Disconnected:
                        LOGGER.info("zk连接断开");
                        break;
                    default:
                        LOGGER.info("状态异常！");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        
        countDownLatch.await();
        String s = zooKeeper.create("/zdk", "zdk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        LOGGER.info(s);
    
        List<String> children = zooKeeper.getChildren("/", false);
        LOGGER.info(children.toString());
        
        if (zooKeeper.exists("/zdk", false) != null) {
            LOGGER.info(getZKData("/zdk"));
        }
        
        zooKeeper.close();
    }
    
    public static String getZKData(String path) {
        try {
            byte[] data = zooKeeper.getData(path, false, new Stat());
            return new String(data);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
