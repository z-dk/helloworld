package algorithms.unionfind;

/**
 * <b>类 名 称</b> :  QuickUnion<br/>
 * <b>类 描 述</b> :  quick-union算法<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/2/27 23:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/2/27 23:04<br/>
 * <b>修改备注</b> :  <br/>
 * quick-union算法重点提高了union()方法的速度，它与quick-find算法互补，仅仅是find与union方法实现上的区别
 * @author zdk
 */
@SuppressWarnings("unused")
public class QuickUnion {
    
    /**
     * 分量id，以触点作为索引
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;
    
    public QuickUnion(int n) {
        count = n;
        id =new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    
    public int count() {
        return count;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        id[pID] = qID;
        count--;
    }
    
    
}
