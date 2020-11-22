package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  MergeSort<br/>
 * <b>类 描 述</b> :  归并排序<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/22 16:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/22 16:25<br/>
 * <b>修改备注</b> :
 */
public class MergeSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15};
        System.out.println("排序前："+ Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println("排序后："+Arrays.toString(a));
    }
    
    /**
     * 方法描述: 将数组a[lo..hi]排序
     * @param [a, lo, hi]       
     * <br/>
     * void
     * <br/><b>创 建 人:</b>zdk
     * <br/><b>创建时间:</b>2020/11/22 16:28
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/22 16:28
     * @since  1.0.0
     */
    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);   // 左边排序
        sort(a, mid+1, hi); // 右边排序
        merge(a, lo, mid, hi);
    }
    
    /**
     * 方法描述: 将有序数组a[lo..mid]与a[mid+1,hi]合并
     * @param [a, lo, mid, hi]       
     * <br/>
     * void
     * <br/><b>创 建 人:</b>zdk
     * <br/><b>创建时间:</b>2020/11/22 16:31
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/11/22 16:31
     * @since  1.0.0
     */
    private static void merge(int[] a, int lo, int mid, int hi){
        // 将a[lo..mid]和a[mid+1..hi]归并
        int len = hi - lo + 1, k = mid + 1;
        int[] rs = new int[len];
        for (int i = 0; i < len; i++) {
            if (k > hi) {
                rs[i] = a[lo++];
            } else if (lo > mid) {
                rs[i] = a[k++];
            } else if (a[lo] > a[k]) {
                rs[i] = a[k++];
            } else {
                rs[i] = a[lo++];
            }
        }
        System.arraycopy(rs, 0, a, hi-len+1, len);
    }
    
}
