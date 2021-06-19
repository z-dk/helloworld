package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    
    //private static final String ZK_ADD = "39.107.107.102:2181";
    private static final String ZK_ADD = "127.0.0.1:2181";
    
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
        System.out.println(printPath("/", 0));
    }
    
    public static String printPath(String path, int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("|  ");
        }
        if ("/".equals(path)) {
            sb.append("/").append("\n");
        } else {
            String zkData = getZKData(path);
            zkData = zkData == null ? "" : zkData;
            sb.append("|--[")
                    .append(new LinkedList<>(Arrays.asList(path.split("/"))).getLast())
                    .append("]:")
                    .append(zkData.replaceAll("\n", 
                            "\n" + Stream.generate(() -> " ").limit(sb.length()).collect(Collectors.joining(""))))
                    .append("\n");
        }
        List<String> children = null;
        try {
            children = getChildren(path);
        } catch (InterruptedException e) {
            LOGGER.error("获取【{}】子节点InterruptedException异常", path, e);
        } catch (KeeperException e) {
            LOGGER.error("获取【{}】子节点KeeperException异常", path, e);
        }
        if (children != null && children.size() > 0) {
            children.forEach(child -> sb.append(printPath((path+"/"+child).replaceAll("//", "/"), depth+1)));
        }
        return sb.toString();
    }
    
    public static String getZKData(String path) {
        try {
            byte[] data = zooKeeper.getData(path, false, new Stat());
            return data==null?"[null]":new String(data);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> getChildren(String path) throws InterruptedException, KeeperException {
        return zooKeeper.getChildren(path, false);
    }
    
    public static String setZKData(String path, String value) {
        try {
            String rs = zooKeeper.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, 
                    CreateMode.PERSISTENT_SEQUENTIAL);
            LOGGER.info("【{}】设置值【{}】成功", path, rs);
            return rs;
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
