package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  QuickSort<br/>
 * <b>类 描 述</b> :  快速排序代码实现<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/22 10:58<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/22 10:58<br/>
 * <b>修改备注</b> :
 */
public class QuickSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15};
        System.out.println("排序前："+Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println("排序后："+Arrays.toString(a));
    }
    
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(a,lo,hi);
        sort(a,lo,mid-1);
        sort(a,mid+1,hi);
    }
    
    private static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int mid = a[lo], left = lo, right = hi+1;
        while (true) {
            while (a[++left] < mid) {
                if (left == hi) {
                    break;
                }
            }
            while (a[--right] > mid) {
                if (right == lo) {
                    break;
                }
            }
            if (left >= right) break;
            int swap = a[left];
            a[left] = a[right];
            a[right] = swap;
        }
        int swap = a[right];
        a[right] = a[lo];
        a[lo] = swap;
        return right;
    }
    
}
