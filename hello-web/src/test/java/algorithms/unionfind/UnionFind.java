package algorithms.unionfind;

/**
 * <b>类 名 称</b> :  QuickUnion<br/>
 * <b>类 描 述</b> :  union-find算法<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/2/27 23:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/2/27 23:04<br/>
 * <b>修改备注</b> :  <br/>
 * union-find算法(即加权quick-union算法):union中随意将一棵树连到另一颗树,现在我们会记录每棵树的大小,并总是将较小的树连接到较大的树上<br/>
 * 需要添加一个数组和一些代码来记录树中的节点数
 * @author zdk
 */
@SuppressWarnings("unused")
public class UnionFind implements UnionFindInterface {
    
    /**
     * 分量id，以触点作为索引
     */
    private int[] id;

    /**
     * 记录每棵树(分量)的大小
     */
    private int[] sz;
    /**
     * 分量数量
     */
    private int count;
    
    public UnionFind(int n) {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    @Override
    public int count() {
        return count;
    }
    
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        if (sz[pID] < sz[qID]) {
            id[pID] = qID;
            sz[qID] += sz[pID];
        } else {
            id[qID] = pID;
            sz[pID] += sz[qID];
        }
        count--;
    }
    
    
}
