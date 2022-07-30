package algorithms.unionfind;

public interface UnionFindInterface {
    
    /**
     * 获取联通图的个数
     * @return 个数
     */
    int count();

    /**
     * 判断p与q是否联通,即是否在同一联通图上
     * @param p p节点
     * @param q q节点
     * @return 是否联通
     */
    boolean connected(int p, int q);

    /**
     * 获取p节点所在图的跟节点
     * @param p p节点
     * @return 根节点索引
     */
    int find(int p);

    /**
     * 联通两个节点
     * @param p p节点
     * @param q q节点
     */
    void union(int p, int q);
}
