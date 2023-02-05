package algorithms.mst;

import java.util.*;

/**
 * jdk版本的prim算法
 * @see edu.princeton.cs.algs4.PrimMST
 * @see edu.princeton.cs.algs4.LazyPrimMST
 */
public class PrimMST {

    /**
     * 边:[v,w,weight]
     */
    private int[][] edges;

    /**
     * 标记是否已在树中
     */
    private boolean[] marked;

    /**
     * 横切边:尚未在树中的节点,且其离树最近的边
     */
    private final PriorityQueue<int[]> outEdges = new PriorityQueue<>(Comparator.comparingInt(array -> array[2]));

    public PrimMST(int[][] e, int n) {
        int l = e.length;
        edges = new int[l][];
        marked = new boolean[n];
        // 维护点对应的所有边及边的权重
        Map<Integer, List<int[]>> pointMap = new HashMap<>(n);
        for (int[] edge : e) {
            List<int[]> vEdges = pointMap.getOrDefault(edge[0], new ArrayList<>());
            List<int[]> wEdges = pointMap.getOrDefault(edge[1], new ArrayList<>());
            vEdges.add(edge);
            wEdges.add(edge);
        }
        // 选择一个点开始
        outEdges.offer(e[0]);
        while (!outEdges.isEmpty()) {
            int[] out = outEdges.poll();
            //outEdges.iterator()
        }


    }
}
