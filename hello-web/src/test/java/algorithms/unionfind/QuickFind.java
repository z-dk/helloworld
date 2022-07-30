package algorithms.unionfind;

/**
 * <b>类 名 称</b> :  QuickFind<br/>
 * <b>类 描 述</b> :  quick find算法实现<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/2/27 22:51<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/2/27 22:51<br/>
 * <b>修改备注</b> :  <br/>
 * quick-find算法分析：<br/>
 * find()操作的速度很快，它只需访问id[]数组一次，但其无法处理大型问题，因为对于每一次输入union()都需要
 * 扫描整个id[]数组。
 * @author zdk
 */
@SuppressWarnings("unused")
public class QuickFind implements UnionFindInterface {
    
    /**
     * 分量id，以触点作为索引(索引对应值为当前联通图跟节点的索引)
     */
    private int[] id;
    /**
     * 分量数量(联通图的个数)
     */
    private int count;
    
    public QuickFind(int n) {
        count = n;
        id =new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 获取联通图的个数
     * @return 个数
     */
    @Override
    public int count() {
        return count;
    }

    /**
     * 判断p与q是否联通,即是否在同一联通图上
     * @param p p节点
     * @param q q节点
     * @return 是否联通
     */
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 获取p节点所在图的跟节点
     * @param p p节点
     * @return 根节点索引
     */
    @Override
    public int find(int p) {
        return id[p];
    }

    /**
     * 联通两个节点
     * @param p p节点
     * @param q q节点
     */
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
    
}
